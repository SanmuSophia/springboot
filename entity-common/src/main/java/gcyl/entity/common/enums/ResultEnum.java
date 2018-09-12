package gcyl.entity.common.enums;

/**
 * 返回值枚举
 *
 * @author lican
 * @date 2018/9/11
 */
public enum ResultEnum {
    SUCCESS("0001", "处理成功");

    String code;

    String mes;

    ResultEnum(String code, String mes) {
        this.code = code;
        this.mes = mes;
    }

    public String getCode() {
        return code;
    }

    public String getMes() {
        return mes;
    }

}
