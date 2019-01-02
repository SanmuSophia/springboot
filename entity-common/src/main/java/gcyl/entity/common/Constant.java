package gcyl.entity.common;

/**
 * 静态常量管理类
 * 1.永远不变或几乎不变的变量
 * 2.与配置变量区分
 * @author lican
 * @date 2018/12/12
 */
public interface Constant {
    //时区
    String GMT = "+8";

    //商品编号前缀
    String G_SN_PREFIX = "MSG";

    //订单编号前缀
    String O_SN_PREFIX = "MSO";
}
