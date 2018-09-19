package gcyl.entity.common.utils;


/**
 * @author lican
 * @date 2018/9/14
 */
public class IpContext {

    private static ThreadLocal<IpContext> context = ThreadLocal.withInitial(IpContext::new);

    private String ip;

    public static IpContext getCurrentContext() {
        return context.get();
    }

    private IpContext() {
    }

    public static void setCurrentContext(String ip) {
        IpContext ipContext = getCurrentContext();
        ipContext.ip = ip;
    }

    public static String getUserIp() {
        return getCurrentContext().getIp();
    }

    public static void clean() {
        context.remove();
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
