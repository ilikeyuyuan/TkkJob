package com.Tkk.job.exceptions;

import com.Tkk.job.enums.StateEnum;

/**
 * @Author WengWenxin
 * @Date 2019/10/05 21:14
 */
public class MyException extends RuntimeException {
    private Integer code;
    private String msg;
    public MyException(StateEnum stateEnum) {
        super(stateEnum.getStateInfo());
        this.code=stateEnum.getState();
        this.msg=stateEnum.getStateInfo();
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
}
