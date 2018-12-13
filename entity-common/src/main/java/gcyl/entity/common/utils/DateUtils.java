package gcyl.entity.common.utils;

import gcyl.entity.common.Constant;

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
   public static Date getDate() {
       return Date.from(LocalDateTime.now(ZoneId.of(Constant.gmt))
               .toInstant(ZoneOffset.of(Constant.gmt)));
   }

   /**
    * 获取当前时间
    * @return 当前时间
    */
   public static long getDateTime() {
      return LocalDateTime.now(ZoneId.of(Constant.gmt))
              .toInstant(ZoneOffset.of(Constant.gmt))
              .toEpochMilli();
   }
}
