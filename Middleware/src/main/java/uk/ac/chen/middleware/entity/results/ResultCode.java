package uk.ac.chen.middleware.entity.results;

/**
 * Definition of ReturnCode
 */
public enum ResultCode {
    /* success */
    SUCCESS(200, "Success"),

    /* common fail */
    FAIL(4001, "Fail"),

    /* parameter error：1000～1999 */
    PARAM_NOT_VALID(4001, "Parameter is invalid"),
    PARAM_IS_BLANK(4002, "Parameter is null"),

    /* File error */
    FILE_NOT_EXIST(4010, "This file does not exist"),

    /* permission error */
    NO_PERMISSION(4020, "Permission denied");

    private Integer code;
    private String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
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

    /**
     * Get message according to code
     *
     * @param code
     * @return message
     */
    public static String getMessageByCode(Integer code) {
        for (ResultCode ele : values()) {
            if (ele.getCode().equals(code)) {
                return ele.getMsg();
            }
        }
        return null;
    }
}
