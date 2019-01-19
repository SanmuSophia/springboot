package gcyl.entity.common.utils;

import gcyl.entity.common.constant.Constant;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * 日期工具,基于LocalDateTime
 * 时区设定为GMT+8
 *
 * @author lican
 * @date 2018/12/12
 */
public class DateUtils {

   /**
    * 获取当前日期
    * @return 当前日期
    */
   public static Date getGmtDate() {
      ZoneId zoneId = ZoneId.systemDefault();
      ZoneOffset zoneOffset = zoneId.getRules().getOffset(LocalDateTime.now(zoneId));
      return Date.from(LocalDateTime.now(ZoneId.of(Constant.GMT8))
              .toInstant(zoneOffset));
   }

   /**
    * 获取当前时间
    * @return 当前时间
    */
   public static long getDateTime() {
      return LocalDateTime.now(ZoneId.of(Constant.GMT8))
              .toInstant(ZoneOffset.of(Constant.GMT8))
              .toEpochMilli();
   }

   /**
    * 获取当天23:59:59:999999999的时间
    * @return 时间戳
    */
   public static long getDateEndTime() {
         return LocalDateTime.now(ZoneId.of(Constant.GMT8))
                 .withHour(23)
                 .withMinute(59)
                 .withSecond(59)
                 .withNano(999999999)
                 .toInstant(ZoneOffset.of(Constant.GMT8))
                 .toEpochMilli();
   }
}
