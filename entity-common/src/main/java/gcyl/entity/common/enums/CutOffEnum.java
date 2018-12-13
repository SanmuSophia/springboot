package gcyl.entity.common.enums;

/**
 * cut_off enum
 *
 * @author lican
 * @date 2018/12/13
 */
public enum CutOffEnum {
    TRUE((byte) 1, "删除"),
    FALSE((byte) 0, "未删除");

    private byte code;
    private String name;

    CutOffEnum(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    public byte getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
