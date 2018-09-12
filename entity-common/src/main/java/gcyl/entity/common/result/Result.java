package gcyl.entity.common.result;


import com.alibaba.druid.support.json.JSONUtils;
import gcyl.entity.common.enums.ResultEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;

/**
 * 结果
 */
public class Result implements Serializable {

    private static final Logger log = LogManager.getLogger(Result.class);

    private boolean success;
    private String code;
    private String msg;
    private String ex;
    private Object data;

    public Result() {
    }

    public void success() {
        this.success(null);
    }

    public void success(Object data) {
        String code = ResultEnum.SUCCESS.getCode();
        String msg = ResultEnum.SUCCESS.getMes();
        this.set(true, code, msg, null, data);
    }

    public void error(String msg) {
        this.set(false, null, msg, null, null);
    }

    public void error(ResultEnum rEnum) {
        this.set(false, rEnum.getCode(), rEnum.getMes(), null, null);
    }

    private void set(boolean success, String code, String mes, String ex, Object data){
        this.success = success;
        this.code = code;
        this.msg = mes;
        this.ex = ex;
        this.data = data;
    }

    public static Logger getLog() {
        return log;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String getEx() {
        return ex;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        return JSONUtils.toJSONString(this);
    }
}
