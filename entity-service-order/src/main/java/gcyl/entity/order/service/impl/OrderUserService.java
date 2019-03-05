package gcyl.entity.order.service.impl;

import com.github.pagehelper.PageHelper;
import gcyl.entity.common.enums.ResultEnum;
import gcyl.entity.common.enums.order.OrderStateEnum;
import gcyl.entity.common.enums.order.PayEnum;
import gcyl.entity.common.result.Result;
import gcyl.entity.domain.mapper.OrderMapper;
import gcyl.entity.domain.mapper.ex.OrderExtMapper;
import gcyl.entity.domain.model.OrderExample;
import gcyl.entity.domain.model.ex.OrderEx;
import gcyl.entity.domain.model.vo.OrderUNumVO;
import gcyl.entity.order.Enum.UListTypeEnum;
import gcyl.entity.order.request.OrderUListRequest;
import gcyl.entity.order.service.IOrderUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户订单管理
 *
 * @author lican
 * @date 2018/12/28
 */
@Slf4j
@Service
public class OrderUserService implements IOrderUserService {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderExtMapper orderExtMapper;

    /**
     * 获取订单数量
     *
     * @param userId  店铺ID
     * @return 订单数量
     */
    @Override
    public OrderUNumVO orderNum(long userId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userId", userId);
        paramMap.put("userCutOff", false);

        int all = orderExtMapper.countByMap(paramMap);

        List<Integer> list = new ArrayList<>();
        paramMap.put("orderStates", list);

        list.add(OrderStateEnum.WR.getCode());
        list.add(OrderStateEnum.WS.getCode());
        list.add(OrderStateEnum.FS.getCode());
        int ordered = orderExtMapper.countByMap(paramMap);

        list.clear();
        list.add(OrderStateEnum.FH.getCode());
        int waitEvaluate = orderExtMapper.countByMap(paramMap);

        list.clear();
        list.add(OrderStateEnum.CS.getCode());
        paramMap.put("isPay", true);
        int refund = orderExtMapper.countByMap(paramMap);

        list.clear();
        list.add(OrderStateEnum.WR.getCode());
        list.add(OrderStateEnum.WS.getCode());
        list.add(OrderStateEnum.FS.getCode());
        paramMap.put("isPay", false);
        int waitPay = orderExtMapper.countByMap(paramMap);

        OrderUNumVO orderUNumVO = new OrderUNumVO();
        orderUNumVO.setAll(all);
        orderUNumVO.setOrdered(ordered);
        orderUNumVO.setWaitPay(waitPay);
        orderUNumVO.setWaitEvaluate(waitEvaluate);
        orderUNumVO.setRefund(refund);

        return orderUNumVO;
    }

    /**
     * 用户订单列表
     *
     * @param request  列表请求参数
     * @return 订单列表
     */
    @Override
    public List<OrderEx> orderList(OrderUListRequest request) {
        long userId = request.getUserId();
        int pageSize = request.getPageSize();
        int pageNum = request.getPageNum();
        UListTypeEnum typeEnum = request.getListType();

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userId", userId);
        if (typeEnum != null && typeEnum != UListTypeEnum.AL) {
            List<Integer> orderStates = new ArrayList<>();
            switch (typeEnum) {
                case OD:
                    orderStates.add(OrderStateEnum.WR.getCode());
                    orderStates.add(OrderStateEnum.WS.getCode());
                    orderStates.add(OrderStateEnum.FS.getCode());
                    break;
                case WP:
                    orderStates.add(OrderStateEnum.WR.getCode());
                    orderStates.add(OrderStateEnum.WS.getCode());
                    orderStates.add(OrderStateEnum.FS.getCode());
                    paramMap.put("isPay", PayEnum.NOT_PAID.getCode());
                    break;
                case WE:
                    orderStates.add(OrderStateEnum.FH.getCode());
                    break;
                case RF:
                    orderStates.add(OrderStateEnum.CS.getCode());
                    paramMap.put("isPay", PayEnum.PAID.getCode());
                    break;
            }
            paramMap.put("orderStates", orderStates);
        }

        PageHelper.startPage(pageNum, pageSize);
        return orderExtMapper.selectUserOdList(paramMap);
    }

    /**
     * 用户订单详情
     * @param userId   用户ID
     * @param orderId  订单ID
     * @return 订单详情
     */
    @Override
    public OrderEx orderDetail(long userId, long orderId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userId", userId);
        paramMap.put("orderId", orderId);
        return orderExtMapper.selectUserOdDetail(paramMap);
    }

    /**
     * 判断是否用户订单
     *
     * @param userId  店铺ID
     * @param orderId 订单ID
     * @return success = true 是
     */
    @Override
    public Result isUserOrder(long userId, long orderId) {
        Result result = new Result();
        OrderExample example = new OrderExample();
        example.createCriteria().andIdEqualTo(orderId).andUserIdEqualTo(userId);
        int count = orderMapper.countByExample(example);
        if (count <= 0) {
            log.info(ResultEnum.O0002.toString());
            result.error(ResultEnum.O0002);
            return result;
        }
        result.success();
        return result;
    }
}
