package gcyl.entity.common.enums.order;

/**
 * 支付方式枚举
 *
 * @author lican
 * @date 2018/12/27
 */
public enum PayWayEnum {

    ONLINE(1, "线上"),
    OFFLINE(2, "线下");

    int code;
    String name;

    PayWayEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static PayWayEnum getEnumByCode(int code) {
        for (PayWayEnum wayEnum : PayWayEnum.values()) {
            if (wayEnum.code == code) {
                return wayEnum;
            }
        }
        return null;
    }

    public int getCode()  {
        return code;
    }
}
