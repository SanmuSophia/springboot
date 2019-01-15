package gcyl.entity.interceptor;

import gcyl.entity.common.enums.ResultEnum;
import gcyl.entity.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

/**
 * 异常拦截
 *
 * @author lican
 * @date 2019/1/7
 */
@Slf4j
@ControllerAdvice
public class MyExceptionHandler {

    /**
     * 请求方式异常捕捉
     * @param e  异常信息
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public Result methodHandler(Exception e) {
        Result result = new Result();
        result.error(ResultEnum.METHOD_ERROR);
        log.error(ResultEnum.METHOD_ERROR.toString());
        log.error(e.getMessage());
        return result;
    }

    /**
     * 请求数据异常捕捉
     * @param e  异常信息
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public Result messageHandler(Exception e) {
        Result result = new Result();
        result.error(ResultEnum.DATA_ERROR);
        log.error(ResultEnum.DATA_ERROR.toString());
        log.error(e.getMessage());
        return result;
    }

    /**
     * 全局异常捕捉处理
     * @param e  异常信息
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception e) {
        Result result = new Result();
        result.error(ResultEnum.ERROR);
        e.printStackTrace();
        return result;
    }
}
