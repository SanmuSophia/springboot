package gcyl.entity.common.enums;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 返回值枚举
 * 0:查询
 * 1:新增
 * 2:修改
 * 3:删除
 * @author lican
 * @date 2018/9/11
 */
public enum ResultEnum {
    SUCCESS("0001", "处理成功"),
    ERROR("9999", "系统异常"),

    /**          店铺           **/
    S0001("S0001", "店铺状态异常"),

    /**          类目           **/
    C1001("C1001", "新增类目失败"),
    C2001("C2001", "修改类目失败"),
    C3001("C3001", "删除类目失败");

    /**
     * 编码
     */
    String code;

    /**
     * 返回信息(给用户查看)
     */
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
