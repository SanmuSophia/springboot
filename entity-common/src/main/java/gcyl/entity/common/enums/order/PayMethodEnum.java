package gcyl.entity.common.enums.order;

/**
 * 支付方式枚举
 *
 * @author lican
 * @date 2018/12/27
 */
public enum PayMethodEnum {
    ALIPAY(1, "支付宝"),
    WECHAT(2, "微信"),
    BLANK(3, "银行卡"),
    WALLET(4, "钱包"),
    PAYMENT(5, "货款"),
    BALANCE(6, "余额");

    int code;
    String name;

    PayMethodEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static PayMethodEnum getEnumByCode(int code) {
        for (PayMethodEnum methodEnum : PayMethodEnum.values()) {
            if (methodEnum.code == code) {
                return methodEnum;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }
}
