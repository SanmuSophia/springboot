package gcyl.entity.domain.mapper.ext;

import gcyl.entity.domain.model.OrderDetail;

import java.util.List;

/**
 * orderDetail extend mapper
 *
 * @author lican
 * @date 2018/10/8
 */
public interface OrderDetailExtMapper {

    /**
     * 批量插入
     * @param orderDetails  订单明细集合
     * @return 大于0插入成功
     */
    int batchInsert(List<OrderDetail> orderDetails);
}