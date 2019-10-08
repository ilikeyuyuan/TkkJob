package com.Tkk.job.config.util;

import com.Tkk.job.dto.Result;
import com.Tkk.job.enums.StateEnum;

/**
 * @Author WengWenxin
 * @Date 2019/10/04 22:30
 */
public class ResultUtil {
    public static Result success(StateEnum stateEnum, Object object) {
        Result result = new Result();
//        Class<?> enumObject=objectEnum.getClass();
//        Method[] declaredMethods=enumObject.getDeclaredMethods();
//        Object o = enumObject.getEnumConstants();
//        try {
//            for (Method method : declaredMethods) {
//                if ("getState".equals(method.getName()))
//                    result.setCode((Integer) method.invoke(o, null));
//                else if("getStateInfo".equals(method.getName()))
//                    result.setMsg((String)method.invoke(o, null));
//            }
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
        result.setCode(stateEnum.getState());
        result.setMsg(stateEnum.getStateInfo());
        result.setData(object);
        return result;
    }

    public static Result error(StateEnum stateEnum) {
        Result result = new Result();
        result.setCode(stateEnum.getState());
        result.setMsg(stateEnum.getStateInfo());
        return result;
    }
}
