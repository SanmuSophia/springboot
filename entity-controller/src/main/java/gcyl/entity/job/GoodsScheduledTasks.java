package gcyl.entity.job;

import gcyl.entity.common.utils.DateUtils;
import gcyl.entity.domain.mapper.ex.GoodsExtMapper;
import gcyl.entity.domain.mapper.ex.GoodsSpecExtMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 *
 * @author lican
 * @date 2019/1/5
 */
@Slf4j
@Component
public class GoodsScheduledTasks {

    @Autowired
    GoodsExtMapper goodsExtMapper;
    @Autowired
    GoodsSpecExtMapper specExtMapper;

    @Scheduled(cron = "0 0 0 * * ?")
    public void restore() {
        log.info("定时恢复日库存开始---------");
        long now = DateUtils.getDateTime();
        specExtMapper.restock(now);
        log.info("定时恢复日库存结算---------");
    }

    @Scheduled(cron = "0 0 0 1 * ?")
    public void resetMonthSales() {
        log.info("定时重置商品月售开始---------");
        long now = DateUtils.getDateTime();
        goodsExtMapper.resetMonthSales(now);
        log.info("定时重置商品月售结算---------");
    }
}
