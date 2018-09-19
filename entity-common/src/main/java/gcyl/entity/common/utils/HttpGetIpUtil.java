package gcyl.entity.common.utils;

import javax.servlet.http.HttpServletRequest;

public class HttpGetIpUtil {

    public HttpGetIpUtil() {
    }

    public static final String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (LogUtils.isInfoEnabled()) {
            LogUtils.info(" - X-Forwarded-For - String ip = " + ip);
        }

        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
            if (ip.length() > 15) {
                String[] ips = ip.split(",");

                for (int index = 0; index < ips.length; ++index) {
                    String strIp = ips[index];
                    if (!"unknown".equalsIgnoreCase(strIp)) {
                        ip = strIp;
                        break;
                    }
                }
            }
        } else {
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
                if (LogUtils.isInfoEnabled()) {
                    LogUtils.info(" - Proxy-Client-IP - String ip=" + ip);
                }
            }

            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
                if (LogUtils.isInfoEnabled()) {
                    LogUtils.info(" - WL-Proxy-Client-IP - String ip=" + ip);
                }
            }

            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
                if (LogUtils.isInfoEnabled()) {
                    LogUtils.info(" - HTTP_CLIENT_IP - String ip=" + ip);
                }
            }

            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
                if (LogUtils.isInfoEnabled()) {
                    LogUtils.info(" - HTTP_X_FORWARDED_FOR - String ip=" + ip);
                }
            }

            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
                if (LogUtils.isInfoEnabled()) {
                    LogUtils.info(" - getRemoteAddr - String ip=" + ip);
                }
            }
        }
        return ip;
    }
}
