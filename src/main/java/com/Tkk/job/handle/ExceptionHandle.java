package com.Tkk.job.handle;

import com.Tkk.job.dto.Result;
import com.Tkk.job.enums.StateEnum;
import com.Tkk.job.exceptions.MyException;
import com.Tkk.job.config.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author WengWenxin
 * @Date 2019/09/25 18:57
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger=LoggerFactory.getLogger(Exception.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof MyException){
            MyException myException=(MyException)e;
            StateEnum stateEnum=StateEnum.stateOf(myException.getCode());
            return ResultUtil.error(stateEnum);
        }else{
            logger.error("系统异常={}",e);
            return ResultUtil.error(StateEnum.USER_UNKNOWN);
        }

    }
}
