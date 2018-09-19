package gcyl.entity.common.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 反射工具类
 *
 * @author lican
 * @date 2018/9/14
 */
public class GenericsUtils {

    /**
     * 通过反射获得父类泛型第一个参数类型
     * 如public ParameterizeType extends SuperParameterizeType<CustomType>，则返回CustomType
     * @param clazz 需要反射的类
     * @return 第一个泛型参数类型，如无则返回当前Class类型
     */
    public static Class getSuperClassGenericType(Class clazz) {
        return getSuperClassGenericType(clazz, 0);
    }

    /**
     * 根据索引通过反射获得父类泛型参数类型
     * @param clazz 需要反射的类
     * @param index 第一个泛型参数类型，如无则返回当前Class类型
     * @return 制定的泛型参数类型，如无则返回当前Class类型
     */
    private static Class getSuperClassGenericType(Class clazz, int index) {
        Type genType = clazz.getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            LogUtils.warn(String.format("%s 的父类非泛型类", clazz.getSimpleName()));
            return Object.class;
        }
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (index >= params.length || index < 0) {
            LogUtils.warn(String.format("索引: %s 超出了  %s 的泛型参数长度:%s", index, clazz.getSimpleName(), params.length));
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            LogUtils.warn(String.format("%s 在父类的泛型参数中不是真正的Class类型", clazz.getSimpleName()));
            return Object.class;
        }
        return (Class) params[index];
    }
}
