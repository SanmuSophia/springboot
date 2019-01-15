package gcyl.entity.common.enums.order;

/**
 * 订单状态枚举
 *
 * @author lican
 * @date 2018/12/27
 */
public enum OrderStateEnum {

    WR(10, "待接单"),
    WS(20, "待上菜(上菜中)"),
    FS(30, "上菜完成"),
    FH(40, "订单完成"),
    EV(41, "已评价"),
    CS(50, "已关闭");

    int code;

    String name;

    OrderStateEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static OrderStateEnum getEnumByCode(int code) {
        for (OrderStateEnum stateEnum : OrderStateEnum.values()) {
            if (stateEnum.code == code) {
                return stateEnum;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }
}

