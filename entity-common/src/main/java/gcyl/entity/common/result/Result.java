package gcyl.entity.common.result;


import com.alibaba.fastjson.JSON;
import gcyl.entity.common.enums.ResultEnum;

import java.io.Serializable;

/**
 * 结果
 */
public class Result implements Serializable {

    private boolean success;
    private String code;
    private String msg;
    private Object data;

    public Result() {
    }

    public void success() {
        this.success(null);
    }

    public void success(Object data) {
        String code = ResultEnum.SUCCESS.getCode();
        String msg = ResultEnum.SUCCESS.getMes();
        this.set(true, code, msg, data);
    }

    public void error(String mes) {
        this.set(false, null, mes, null);
    }

    public void error(ResultEnum rEnum) {
        this.set(false, rEnum.getCode(), rEnum.getMes(), null);
    }

    private void set(boolean success, String code, String mes, Object data){
        this.success = success;
        this.code = code;
        this.msg = mes;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
