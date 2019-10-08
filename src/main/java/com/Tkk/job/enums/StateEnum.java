package com.Tkk.job.enums;

/**
 * @Author WengWenxin
 * @Date 2019/10/03 22:41
 */
public enum StateEnum {
    USER_LOGINFAIL(-1, "密码或帐号输入有误"), USER_SUCCESS(0, "登录成功"), USER_NULL_AUTH_INFO(-1006,
            "注册信息为空"),USER_UPLOAD_IMAGE_NONE(-2,"上传图片不能为空"),USER_UPLOAD_IMAGE_FAILD(-3,"上传图片失败"),
    USER_LOGIN_NULL(-4,"用户名或密码及身份不许为空"),USER_UNKNOWN(-5,"未知错误"),USERNAME_ISEXIST(-6,"用户名已存在")
    ;

    private int state;

    private String stateInfo;

    private StateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static StateEnum stateOf(int index) {
        for (StateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }

}
