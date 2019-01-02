package gcyl.entity.common.enums.goods;

/**
 * 上架状态枚举
 *
 * @author lican
 * @date 2018/12/20
 */
public enum OnSaleEnum {

    TRUE(true, "上架"),
    FALSE(false, "下架");

    private boolean code;
    private String name;

    OnSaleEnum(boolean code, String name) {
        this.code = code;
        this.name = name;
    }

    public boolean getCode() {
        return code;
    }

}
