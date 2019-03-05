package gcyl.entity.common.enums.order;

/**
 * 支付状态枚举
 *
 * @author lican
 * @date 2018/12/27
 */
public enum PayEnum {

    PAID(true, "已支付"),
    NOT_PAID(false, "未支付");

    boolean code;
    String name;

    PayEnum(boolean code, String name) {
        this.code = code;
        this.name = name;
    }

    public boolean getCode() {
        return code;
    }

}
