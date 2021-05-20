package uk.ac.chen.middleware.entity.results;

import java.io.Serializable;

/**
 * @author: Qiuyu
 * Unified return entity
 */
public class JsonResult<T> implements Serializable {

    private static final long serialVersionUID = -1864171773128134798L;

    private Boolean success;
    private Integer code;
    private String msg;
    private T data;

    public JsonResult() {
    }

    public JsonResult(boolean success) {
        this.success = success;
        this.code = success ? ResultCode.SUCCESS.getCode() : ResultCode.FAIL.getCode();
        this.msg = success ? ResultCode.SUCCESS.getMsg() : ResultCode.FAIL.getMsg();
    }

    public JsonResult(boolean success, ResultCode resultEnum) {
        this.success = success;
        this.code = success ? ResultCode.SUCCESS.getCode() :
                (resultEnum == null ? ResultCode.FAIL.getCode() : resultEnum.getCode());
        this.msg = success ? ResultCode.SUCCESS.getMsg() :
                (resultEnum == null ? ResultCode.FAIL.getMsg() : resultEnum.getMsg());
    }

    public JsonResult(boolean success, T data) {
        this.success = success;
        this.code = success ? ResultCode.SUCCESS.getCode() : ResultCode.FAIL.getCode();
        this.msg = success ? ResultCode.SUCCESS.getMsg() : ResultCode.FAIL.getMsg();
        this.data = data;
    }

    public JsonResult(boolean success, ResultCode resultEnum, T data) {
        this.success = success;
        this.code = success ? ResultCode.SUCCESS.getCode() :
                (resultEnum == null ? ResultCode.FAIL.getCode() : resultEnum.getCode());
        this.msg = success ? ResultCode.SUCCESS.getMsg() :
                (resultEnum == null ? ResultCode.FAIL.getMsg() : resultEnum.getMsg());
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
