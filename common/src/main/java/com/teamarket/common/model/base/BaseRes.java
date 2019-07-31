package com.teamarket.common.model.base;

/**
 * ${enclosing_method}:${todo} Description &lt;br/&gt;
 * ${todo} Describe applicable conditions of method - Optional.&lt;br/&gt;
 * ${todo} Description of method execution process - Optional.&lt;br/&gt;
 * ${todo} Describe usage of method - Optional.&lt;br/&gt;
 *
 * @exception ${todo}
 * Description &lt;br/&gt;
 * ${tags}
 * ${todo} Description &lt;br/&gt;
 */
public class BaseRes<T> {

    private int code;

    private String msg;

    private T result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
