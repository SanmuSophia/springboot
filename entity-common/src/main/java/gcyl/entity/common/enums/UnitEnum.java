package gcyl.entity.common.enums;

/**
 * 单位类型枚举
 *
 * @author lican
 * @date 2018/12/18
 */
public enum UnitEnum {

    MS((byte) 1, "美食");

    byte code;

    String name;

    UnitEnum(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    public byte getCode() {
        return code;
    }

}
