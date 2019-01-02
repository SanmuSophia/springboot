package gcyl.entity.order.Enum;


/**
 * 店铺订单列表类型枚举
 *
 * @author lican
 * @date 2018/12/29
 */
public enum SListTypeEnum {

    WAIT_RECEIVE(10, "待接单"),
    WAIT_SERVING(20, "待上菜(上菜中)"),
    WAIT_PAY(25, "待付款"),
    FINISH(40, "订单完成"),
    CLOSE(50, "已关闭");

    int code;

    String name;

    SListTypeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static SListTypeEnum getEnumByCode(int code) {
        for (SListTypeEnum typeEnum : SListTypeEnum.values()) {
            if (typeEnum.code == code) {
                return typeEnum;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }
}
