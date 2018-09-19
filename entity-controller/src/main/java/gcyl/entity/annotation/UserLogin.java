package gcyl.entity.annotation;

import java.lang.annotation.*;

/**
 * 用户登录
 *
 * @author lican
 * @date 2018/9/14
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UserLogin {
    String value() default "用户登录";
}
