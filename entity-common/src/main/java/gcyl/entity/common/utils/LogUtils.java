package gcyl.entity.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lican
 * @date 2018/9/4
 */
public final class LogUtils {
    /**
     * 错误输入日志
     */
    private static final Logger log = LoggerFactory.getLogger(LogUtils.class);

    /**
     * 记录一直 info信息 日志调用
     */
    public static void info(String message) {
        StringBuilder s = new StringBuilder();
        s.append((message));
        log.info(s.toString());
    }

    /**
     * 记录一直 info信息 日志调用
     */
    public static void info(String messageFormat, String message) {
        log.info(messageFormat, message);
    }

    /**
     * Info 级的 异常 日志调用
     */
    public static void info(String message, Throwable e) {
        StringBuilder s = new StringBuilder();
        s.append("exception : -->>");
        s.append((message));
        log.info(s.toString(), e);
    }

    /**
     * Warn 级的 日志调用
     */
    public static void warn(String message) {
        StringBuilder s = new StringBuilder();
        s.append(message);
        log.warn(s.toString());
    }

    /**
     * Warn 级的 异常 日志调用
     */
    public static void warn(String message, Throwable e) {
        StringBuilder s = new StringBuilder();
        s.append("exception : -->>");
        s.append((message));
        log.warn(s.toString(), e);
    }

    /**
     * Debug 级的日志调用
     */
    public static void debug(String message) {
        StringBuilder s = new StringBuilder();
        s.append(message);
        log.debug(s.toString());
    }

    /**
     * Debug 级的 异常 日志调用
     */
    public static void debug(String message, Throwable e) {
        StringBuilder s = new StringBuilder();
        s.append("exception : -->>");
        s.append((message));
        log.debug(s.toString(), e);
    }

    /**
     * Error 级的日志调用
     */
    public static void error(String message) {
        StringBuilder s = new StringBuilder();
        s.append(message);
        log.error(s.toString());
    }

    /**
     * Error 级的 异常 日志调用
     */
    public static void error(String message, Throwable e) {
        StringBuilder s = new StringBuilder();
        s.append("exception : -->>");
        s.append((message));
        log.error(s.toString(), e);
    }


    public static boolean isInfoEnabled() {
        return log.isInfoEnabled();
    }
}
