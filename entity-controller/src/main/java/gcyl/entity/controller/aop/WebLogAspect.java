package gcyl.entity.controller.aop;

import com.alibaba.fastjson.JSON;
import gcyl.entity.common.utils.LogUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author lican
 * @date 2018/9/4
 */
@Aspect
@Component
@Order(1)
public class WebLogAspect {

    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * gcyl.entity.controller..*.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void webLog(){
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        StringBuilder sb = new StringBuilder("\r\n");
        if ("GET".equals(request.getMethod())) {
            sb.append("\r\n" + "url: " + request.getRequestURL().toString());
            if (request.getQueryString() != null) {
                sb.append("?" + request.getQueryString());
            }
            sb.append("\r\n" + "ip: " + request.getRemoteAddr());
            sb.append("\r\n" + "content-type: " + request.getContentType());
            sb.append("\r\n" + "method : " + request.getMethod());
        } else {
            sb.append("\r\n" + "url: " + request.getRequestURL().toString());
            sb.append("\r\n" + "ip: " + request.getRemoteAddr());
            sb.append("\r\n" + "content-type: " + request.getContentType());
            sb.append("\r\n" + "method : " + request.getMethod());
//            sb.append(this.getRequestBody(request));
        }
        sb.append("\r\n");
        LogUtils.debug(sb.toString());
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        // 处理完请求，返回内容
        StringBuilder sb = new StringBuilder("\r\n\n");
        sb.append("response: " + JSON.toJSON(ret) + "\r\n");
        sb.append("time: " + (System.currentTimeMillis() - startTime.get()) + "ms"  + "\r\n");
        LogUtils.debug(sb.toString());
    }

    /**
     * 读取请求体
     */
    private String getRequestBody(HttpServletRequest request) {
        BufferedReader reader;
        String str;
        StringBuilder sb = new StringBuilder();
        try {
            reader = request.getReader();
            request.getInputStream();
            while ((str = reader.readLine()) != null) {
                sb.append(str);
            }
        } catch (IOException e) {
            return "";
        }
        return sb.toString();
    }
}

