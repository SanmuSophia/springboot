package gcyl.entity.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;
import java.util.Map;

/**
 * json操作工具类，基于fastJson封装
 *
 * @author lican
 * @date 2018/9/4
 */
public final class JsonUtils {

    /**
     * 默认json格式化方式
     */
    private static final SerializerFeature[] DEFAULT_FORMAT = {
            SerializerFeature.WriteMapNullValue, // 输出空置字段
            SerializerFeature.WriteNullListAsEmpty, // list字段如果为null，输出为[]，而不是null
            SerializerFeature.WriteNullNumberAsZero, // 数值字段如果为null，输出为0，而不是null
            SerializerFeature.WriteNullBooleanAsFalse, // Boolean字段如果为null，输出为false，而不是null
            SerializerFeature.WriteNullStringAsEmpty // 字符类型字段如果为null，输出为""，而不是null
    };

    private JsonUtils() {
    }

    /**
     * 从json获取指定key的字符串
     *
     * @param json json字符串
     * @param key  字符串的key
     * @return 指定key的值
     */
    public static Object getStringFromJSONObject(final String json, final String key) {
        return JSON.parseObject(json).getString(key);
    }

    /**
     * 将字符串转换成JSON字符串
     *
     * @param jsonString json字符串
     * @return 转换成的json对象
     */
    public static JSONObject getJSONFromString(final String jsonString) {
        return JSON.parseObject(jsonString);
    }

    /**
     * 将json字符串，转换成指定java bean
     *
     * @param jsonStr   json串对象
     * @param beanClass 指定的bean
     * @param <T>       任意bean的类型
     * @return 转换后的java bean对象
     */
    public static <T> T toBean(String jsonStr, Class<T> beanClass) {
        JSONObject jo = JSON.parseObject(jsonStr);
        jo.put(JSON.DEFAULT_TYPE_KEY, beanClass.getName());
        return JSON.parseObject(jo.toJSONString(), beanClass);
    }

    /**
     * 将JSON转换正JavaBeanList
     *
     * @param jsonStr    json串对象
     * @param beanClass  指定的bean
     * @return 转换后的java bean list对象
     */
    public static <T> List<T> toBeanList(String jsonStr, Class<T> beanClass) {
        List<T> ts = null;
        try {
            JSONObject jo = JSON.parseObject(jsonStr);
            jo.put(JSON.DEFAULT_TYPE_KEY, beanClass.getName());
            ts = JSON.parseArray(jo.toJSONString(), beanClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ts;
    }

    /**
     * 将json字符串数组转换成实体列表
     * @param jsonStr    json串对象
     * @param beanClass  指定的bean
     * @return 转换后的java bean list对象
     */
    public static <T> List<T> arrayToBeanList(String jsonStr, Class<T> beanClass) {
        List<T> ts = null;
        try {
            ts = JSON.parseArray(jsonStr, beanClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ts;
    }

    /**
     * 转换实体
     * @param json
     * @param type
     * @param <T>
     * @return
     */
//    public static <T> RespBase<T> toBeanBody(String json, Class<T> type) {
//        try {
//             return JSON.parseObject(json, new TypeReference<RespBase<T>>(type){});
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    /**
     * 转换实体
     * @param json
     * @param type
     * @param <T>
     * @return
     */
//    public static <T> RespBase<List<T>> toBeanBodyList(String json, Class<T> type) {
//        try {
//            return JSON.parseObject(json, new TypeReference<RespBase<List<T>>>(type){});
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }


    /**
     * @param obj 需要转换的java bean
     * @param <T> 入参对象类型泛型
     * @return 对应的json字符串
     */
    public static <T> String toJson(T obj) {
        return JSON.toJSONString(obj, DEFAULT_FORMAT);
    }

    /**
     * 通过Map生成一个json字符串
     *
     * @param map 需要转换的map
     * @return json串
     */
    public static String toJson(Map<String, Object> map) {
        return JSON.toJSONString(map, DEFAULT_FORMAT);
    }

    /**
     * 美化传入的json,使得该json字符串容易查看
     *
     * @param jsonString 需要处理的json串
     * @return 美化后的json串
     */
    public static String prettyFormatJson(String jsonString) {
        return JSON.toJSONString(getJSONFromString(jsonString), true);
    }

    /**
     * 将传入的json字符串转换成Map
     *
     * @param jsonString 需要处理的json串
     * @return 对应的map
     */
    public static Map<String, Object> toMap(String jsonString) {
        return getJSONFromString(jsonString);
    }

}