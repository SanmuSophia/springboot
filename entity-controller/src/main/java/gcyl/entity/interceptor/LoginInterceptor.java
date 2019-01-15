package gcyl.entity.interceptor;

import gcyl.entity.common.annotation.UserLogin;
import gcyl.entity.common.utils.HttpGetIpUtils;
import gcyl.entity.common.utils.IpContext;
import gcyl.entity.common.utils.LogUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 拦截器
 *
 * @author lican
 * @date 2018/9/14
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String userIp = HttpGetIpUtils.getIpAddress(request);
        LogUtils.debug("当前用户请求ip:" + userIp);
        IpContext.setCurrentContext(userIp);

        if (handler instanceof  HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            UserLogin userLogin = method.getAnnotation(UserLogin.class);
            if (userLogin == null) {
                return true;
            }
        }
        System.out.println("------------------------------");
        return true;
    }
}
