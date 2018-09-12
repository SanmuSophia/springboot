package gcyl.entity.service.goods.impl;

import gcyl.entity.service.goods.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lican
 * @date 2018/9/7
 */
@Service
public class TestServiceImpl implements ITestService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public String test() {
        return orderMapper.selectByPrimaryKey(1000L).getOrderId().toString();
    }
}
