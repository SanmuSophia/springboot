package gcyl.entity.order.service.impl;

import com.github.pagehelper.PageHelper;
import gcyl.entity.common.enums.ResultEnum;
import gcyl.entity.common.enums.order.OrderStateEnum;
import gcyl.entity.common.enums.order.PayEnum;
import gcyl.entity.common.result.Result;
import gcyl.entity.domain.mapper.OrderMapper;
import gcyl.entity.domain.mapper.ext.OrderExtMapper;
import gcyl.entity.domain.model.OrderExample;
import gcyl.entity.domain.model.ext.OrderExt;
import gcyl.entity.domain.model.vo.OrderUNumVO;
import gcyl.entity.order.Enum.SListTypeEnum;
import gcyl.entity.order.Enum.UListTypeEnum;
import gcyl.entity.order.request.OrderUListRequest;
import gcyl.entity.order.service.IOrderUserService;
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
        return orderExtMapper.countUserOdNum(userId);
    }

    /**
     * 用户订单列表
     *
     * @param request  列表请求参数
     * @return 订单列表
     */
    @Override
    public List<OrderExt> orderList(OrderUListRequest request) {
        long userId = request.getUserId();
        int pageSize = request.getPageSize();
        int pageNum = request.getPageNum();
        UListTypeEnum typeEnum = request.getTypeEnum();

        List<Integer> orderStates = new ArrayList<>();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userId", userId);
        switch (typeEnum) {
            case ALL:
                orderStates.add(OrderStateEnum.WAIT_RECEIVE.getCode());
                orderStates.add(OrderStateEnum.WAIT_SERVING.getCode());
                orderStates.add(OrderStateEnum.FINISH_SERVING.getCode());
                orderStates.add(OrderStateEnum.FINISH.getCode());
                orderStates.add(OrderStateEnum.EVALUATE.getCode());
                orderStates.add(OrderStateEnum.CLOSE.getCode());
                break;
            case ORDERED:
                orderStates.add(OrderStateEnum.WAIT_RECEIVE.getCode());
                orderStates.add(OrderStateEnum.WAIT_SERVING.getCode());
                orderStates.add(OrderStateEnum.FINISH_SERVING.getCode());
                break;
            case WAIT_PAY:
                orderStates.add(OrderStateEnum.WAIT_RECEIVE.getCode());
                orderStates.add(OrderStateEnum.WAIT_SERVING.getCode());
                orderStates.add(OrderStateEnum.FINISH_SERVING.getCode());
                paramMap.put("isPay", PayEnum.NOT_PAID.getCode());
                break;
            case WAIT_EVALUATE:
                orderStates.add(OrderStateEnum.FINISH.getCode());
                break;
            case REFUND:
                orderStates.add(OrderStateEnum.CLOSE.getCode());
                paramMap.put("isPay", PayEnum.PAID.getCode());
                break;
        }
        paramMap.put("orderStates", orderStates);

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
    public OrderExt orderDetail(long userId, long orderId) {
        return orderExtMapper.selectUserOdDetail(userId, orderId);
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
            result.error(ResultEnum.O0002);
            return result;
        }
        result.success();
        return result;
    }
}
