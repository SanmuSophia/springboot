package gcyl.entity.common.enums;

/**
 * cut_off enum
 *
 * @author lican
 * @date 2018/12/13
 */
public enum CutOffEnum {

    TRUE(true, "删除"),
    FALSE(false, "未删除");

    boolean code;
    String name;

    CutOffEnum(boolean code, String name) {
        this.code = code;
        this.name = name;
    }

    public boolean getCode() {
        return code;
    }

}
