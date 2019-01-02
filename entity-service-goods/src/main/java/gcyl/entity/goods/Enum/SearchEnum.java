package gcyl.entity.goods.Enum;

/**
 * 商品搜索枚举
 *
 * @author lican
 * @date 2018/12/18
 */
public enum SearchEnum {

    ALL(0, "所有"),
    SELL_OUT(1, "售罄"),
    HOT(2, "热销"),
    RECOMMEND(3, "店长推荐"),
    DEFAULT(4, "默认"),
    CATEGORY(11, "类目");

    private int code;

    private String name;

    SearchEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static SearchEnum getEnumByCode(int code) {
        for (SearchEnum searchEnum : SearchEnum.values()) {
            if (searchEnum.code == code) {
                return searchEnum;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

}
