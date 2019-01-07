package gcyl.entity.order.service.impl;

import com.github.pagehelper.PageHelper;
import gcyl.entity.common.enums.ResultEnum;
import gcyl.entity.common.enums.goods.StockEnum;
import gcyl.entity.common.enums.order.OrderStateEnum;
import gcyl.entity.common.enums.order.PayEnum;
import gcyl.entity.common.result.Result;
import gcyl.entity.common.utils.DateUtils;
import gcyl.entity.domain.mapper.OrderMapper;
import gcyl.entity.domain.mapper.ex.OrderExtMapper;
import gcyl.entity.domain.model.Order;
import gcyl.entity.domain.model.OrderExample;
import gcyl.entity.domain.model.ex.OrderEx;
import gcyl.entity.domain.model.form.OrderGoodsForm;
import gcyl.entity.goods.service.IGoodsService;
import gcyl.entity.order.Enum.SListTypeEnum;
import gcyl.entity.order.request.OrderSListRequest;
import gcyl.entity.order.service.IOrderService;
import gcyl.entity.order.service.IOrderShopService;
import gcyl.entity.domain.model.vo.OrderSNumVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 店铺订单管理
 *
 * @author lican
 * @date 2018/12/28
 */
@Service
public class OrderShopServiceImpl implements IOrderShopService {

    private static Logger logger = LoggerFactory.getLogger(OrderShopServiceImpl.class);

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderExtMapper orderExtMapper;

    @Autowired
    IOrderService orderService;
    @Autowired
    IGoodsService goodsService;

    /**
     * 获取订单数量
     *
     * @param shopId  店铺ID
     * @return 订单数量
     */
    @Override
    public OrderSNumVO orderNum(long shopId) {
        Map<String, Object> paramMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        paramMap.put("orderStates", list);
        paramMap.put("shopId", shopId);
        paramMap.put("shopCutOff", false);

        list.add(OrderStateEnum.WAIT_RECEIVE.getCode());
        int waitReceive = orderExtMapper.countByMap(paramMap);

        list.clear();
        list.add(OrderStateEnum.WAIT_SERVING.getCode());
        int waitServing = orderExtMapper.countByMap(paramMap);

        list.clear();
        list.add(OrderStateEnum.FINISH.getCode());
        list.add(OrderStateEnum.EVALUATE.getCode());
        int finish = orderExtMapper.countByMap(paramMap);

        list.clear();
        list.add(OrderStateEnum.CLOSE.getCode());
        int close = orderExtMapper.countByMap(paramMap);

        list.clear();
        list.add(OrderStateEnum.WAIT_SERVING.getCode());
        list.add(OrderStateEnum.FINISH_SERVING.getCode());
        paramMap.put("isPay", false);
        int waitPay = orderExtMapper.countByMap(paramMap);

        OrderSNumVO orderSNumVO = new OrderSNumVO();
        orderSNumVO.setWaitReceive(waitReceive);
        orderSNumVO.setWaitServing(waitServing);
        orderSNumVO.setWaitPay(waitPay);
        orderSNumVO.setFinish(finish);
        orderSNumVO.setClose(close);

        return orderSNumVO;
    }

    /**
     * 店铺订单列表
     *
     * @param request  列表请求参数
     * @return 订单列表
     */
    @Override
    public List<OrderEx> orderList(OrderSListRequest request) {
        long shopId = request.getShopId();
        int pageSize = request.getPageSize();
        int pageNum = request.getPageNum();
        SListTypeEnum typeEnum = request.getTypeEnum();

        List<Integer> orderStates = new ArrayList<>();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("shopId", shopId);
        switch (typeEnum) {
            case WAIT_RECEIVE:
                orderStates.add(OrderStateEnum.WAIT_RECEIVE.getCode());
                break;
            case WAIT_SERVING:
                orderStates.add(OrderStateEnum.WAIT_SERVING.getCode());
                break;
            case WAIT_PAY:
                orderStates.add(OrderStateEnum.WAIT_RECEIVE.getCode());
                orderStates.add(OrderStateEnum.WAIT_SERVING.getCode());
                paramMap.put("isPay", PayEnum.NOT_PAID.getCode());
                break;
            case FINISH:
                orderStates.add(OrderStateEnum.FINISH.getCode());
                orderStates.add(OrderStateEnum.EVALUATE.getCode());
                break;
            case CLOSE:
                orderStates.add(OrderStateEnum.CLOSE.getCode());
                break;
        }
        paramMap.put("orderStates", orderStates);

        PageHelper.startPage(pageNum, pageSize);
        return orderExtMapper.selectShopOdList(paramMap);
    }

    /**
     * 店铺订单详情
     * @param shopId   店铺ID
     * @param orderId  订单ID
     * @return 订单详情
     */
    @Override
    public OrderEx orderDetail(long shopId, long orderId) {
        return orderExtMapper.selectShopOdDetail(shopId, orderId);
    }

    /**
     * 拒绝接单
     *
     * @param shopId   店铺ID
     * @param orderId  订单ID
     * @param reason   拒接原因
     * @return 拒绝返回
     */
    @Override
    @Transactional
    public Result refuse(long shopId, long orderId, String reason) {
        Result result = this.isShopOrder(shopId, orderId);
        if (!result.isSuccess()) return result;

        //将库存加回去
        List<OrderGoodsForm> goodsForms = orderExtMapper.selectOrderGoodsNum(orderId);
        for (OrderGoodsForm goodsForm : goodsForms) {
            long specId = goodsForm.getSpecId();
            int num = goodsForm.getNum();
            result = goodsService.changeStock(specId, num, StockEnum.ADD);
            if (!result.isSuccess()) return result;
        }

        Order order = new Order();
        order.setId(orderId);
        order.setDescription(reason);
        return orderService.changeState(order, OrderStateEnum.CLOSE);
    }

    /**
     * 接单
     *
     * @param shopId   店铺ID
     * @param orderId  订单ID
     * @return 接单返回
     */
    @Override
    public Result receive(long shopId, long orderId) {
        Result result = this.isShopOrder(shopId, orderId);
        if (!result.isSuccess()) return result;

        Order order = new Order();
        order.setId(orderId);
        return orderService.changeState(order, OrderStateEnum.WAIT_SERVING);
    }

    /**
     * 上菜完成
     *
     * @param shopId   店铺ID
     * @param orderId  订单ID
     * @return 完成返回
     */
    @Override
    public Result finishServing(long shopId, long orderId) {
        Result result = this.isShopOrder(shopId, orderId);
        if (!result.isSuccess()) return result;

        boolean isPay = orderExtMapper.selectIsPay(orderId);
        Order order = new Order();
        order.setId(orderId);
        if (isPay) {
            return orderService.changeState(order, OrderStateEnum.FINISH);
        } else {
            return orderService.changeState(order, OrderStateEnum.FINISH_SERVING);
        }
    }

    /**
     * 确认收款
     *
     * @param shopId   店铺ID
     * @param orderId  订单ID
     * @return 收款返回
     */
    @Override
    public Result confirmReceipt(long shopId, long orderId) {
        Result result = this.isShopOrder(shopId, orderId);
        if (!result.isSuccess()) return result;

        //订单状态验证
        Order oldOrder = orderExtMapper.selectForStateUp(orderId);
        int orderStare = oldOrder.getOrderState();
        if (orderStare != OrderStateEnum.FINISH_SERVING.getCode()
                || orderStare != OrderStateEnum.WAIT_SERVING.getCode()) {
            logger.info(ResultEnum.O2015.toString());
            result.error(ResultEnum.O2015);
            return result;
        }

        Order order = new Order();
        order.setId(orderId);
        order.setGmtPay(DateUtils.getDate());

        //判断是否上菜完成,若完成则修改订单为已完成
        if (orderStare == OrderStateEnum.FINISH_SERVING.getCode()) {
            return orderService.changeState(order, OrderStateEnum.FINISH);
        }

        int i = orderMapper.updateByPrimaryKeySelective(order);
        if (i <= 0) {
            logger.info(ResultEnum.O2021.toString());
            result.error(ResultEnum.O2021);
            return result;
        }

        result.success();
        return result;
    }

    /**
     * 判断是否店铺订单
     *
     * @param shopId  店铺ID
     * @param orderId 订单ID
     * @return success = true 是
     */
    @Override
    public Result isShopOrder(long shopId, long orderId) {
        Result result = new Result();
        OrderExample example = new OrderExample();
        example.createCriteria().andIdEqualTo(orderId).andShopIdEqualTo(shopId);
        int count = orderMapper.countByExample(example);
        if (count <= 0) {
            logger.info(ResultEnum.O0001.toString());
            result.error(ResultEnum.O0001);
            return result;
        }
        result.success();
        return result;
    }
}
