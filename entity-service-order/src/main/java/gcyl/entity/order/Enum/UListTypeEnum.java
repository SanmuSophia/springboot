package gcyl.entity.order.Enum;


/**
 * 用户订单列表类型枚举
 *
 * @author lican
 * @date 2018/12/29
 */
public enum UListTypeEnum {

    ALL(0, "所有"),
    ORDERED(24, "待上菜(上菜中)"),
    WAIT_PAY(25, "待付款"),
    WAIT_EVALUATE(40, "待评价"),
    REFUND(51, "已关闭");

    int code;

    String name;

    UListTypeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static UListTypeEnum getEnumByCode(int code) {
        for (UListTypeEnum typeEnum : UListTypeEnum.values()) {
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
