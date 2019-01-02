package gcyl.entity.common.enums.order;

/**
 * 抵扣枚举
 *
 * @author lican
 * @date 2018/12/27
 */
public enum DeductEnum {

    CONSUMPTION(1, "消费卷");

    int code;
    String name;

    DeductEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }
}
