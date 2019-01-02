package gcyl.entity.goods.Enum;


/**
 * 商品排序枚举
 * 
 * @author lican
 * @date 2018/12/21
 */
public enum SortEnum {
    
    DEFAULT(1, "默认"),
    SELL_OUT(2, "售罄升序");

    private int code;
    private String name;

    SortEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static SortEnum getEnumByCode(int code) {
        for (SortEnum sortEnum : SortEnum.values()) {
            if (sortEnum.code == code) {
                return sortEnum;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

}
