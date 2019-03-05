package gcyl.entity.aop;

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

    @Pointcut("execution(public * gcyl.entity.controller..*.*(..)) " +
            "&& (@annotation(org.springframework.web.bind.annotation.*))")
    public void webLog(){
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) return;
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        StringBuilder sb = new StringBuilder();
        if ("GET".equals(request.getMethod())) {
            sb.append("\r\n" + "url: ").append(request.getRequestURL().toString());
            if (request.getQueryString() != null) {
                sb.append("?").append(request.getQueryString());
            }
            sb.append("\r\n" + "content-type: ").append(request.getContentType())
              .append("\r\n" + "method : ").append(request.getMethod());
        } else {
            sb.append("\r\n" + "url: ").append(request.getRequestURL().toString())
              .append("\r\n" + "content-type: ").append(request.getContentType())
              .append("\r\n" + "method : ").append(request.getMethod())
              .append("\r\n").append(this.getRequestBody(request));
        }
        LogUtils.debug(sb.toString());
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        // 处理完请求，返回内容
        String str = "\r\n";
        str += "response: " + JSON.toJSON(ret) + "\r\n";
        str += "time: " + (System.currentTimeMillis() - startTime.get()) + "ms"  + "\r\n";
        LogUtils.debug(str);
    }

    /**
     * 读取请求体
     */
    private String getRequestBody(HttpServletRequest request) {
        BufferedReader reader;
        StringBuilder sb = new StringBuilder();
        int len;
        char[] buf = new char[1024];
        try {
            reader = request.getReader();
            request.getInputStream();
            while ((len = reader.read(buf)) != -1) {
                sb.append(new String(buf, 0, len));
            }
        } catch (IOException e) {
            return "";
        }
        return sb.toString();
    }
}

