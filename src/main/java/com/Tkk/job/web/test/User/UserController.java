package com.Tkk.job.web.test.User;

import com.Tkk.job.config.util.HttpServletRequestUtil;
import com.Tkk.job.config.util.ResultUtil;
import com.Tkk.job.dto.ImageHolder;
import com.Tkk.job.dto.Result;
import com.Tkk.job.entity.LocalAuth;
import com.Tkk.job.enums.StateEnum;
import com.Tkk.job.service.LocalAuthService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author WengWenxin
 * @Date 2019/10/04 14:13
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private LocalAuthService localAuthService;

    @PostMapping("/logincheck")
    public Result logincheck(@RequestBody JSONObject jsonParam, HttpServletRequest request) {
        if(jsonParam.get("username")==null||jsonParam.get("password")==null||jsonParam.get("userType")==null)
            return ResultUtil.error(StateEnum.USER_LOGIN_NULL);
        String userName=jsonParam.get("username").toString();
        String password=jsonParam.get("password").toString();
        Integer userType=Integer.valueOf(jsonParam.get("userType").toString());
        Map<String, Object> modelMap = new HashMap<>();
        //获取用户名,密码
//        String userName = HttpServletRequestUtil.getString(request, "userName");
//        String password = HttpServletRequestUtil.getString(request, "password");
//        Integer userType = HttpServletRequestUtil.getInt(request, "userType");
        //判空
        if (userName != null && password != null && userType != null) {
            LocalAuth localAuth = localAuthService.getLocalAuthByUsernameAndPwd(userName, password, userType);
            if (localAuth != null) {
                //在session中设置用户信息
                request.getSession().setAttribute("user", localAuth.getPersonInfo());
                modelMap.put("user", localAuth.getPersonInfo());
                //获取到信息说明用户名及密码正确
                return ResultUtil.success(StateEnum.USER_SUCCESS, modelMap);
            } else {
                return ResultUtil.error(StateEnum.USER_LOGINFAIL);
                //return ResultUtil.success(StateEnum.USER_SUCCESS, modelMap);
            }
        }
        return ResultUtil.error(StateEnum.USER_UNKNOWN);
    }

    @PostMapping("/testFile")
    public void testFile(HttpServletRequest request) {
        CommonsMultipartFile shopImg = null;
        // 文件解析器 解析request里面的
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        // 判断是否有上传文件流
        if (commonsMultipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
        }
//        else {
//            return ResultUtil.error(StateEnum.UPLOAD_IMAGE_NONE);
//        }
        if (shopImg != null) {
            try {
                ImageHolder imageHolder = new ImageHolder(shopImg.getOriginalFilename(), shopImg.getInputStream());
                localAuthService.addshopImg(imageHolder);
            } catch (Exception e) {
//                return ResultUtil.error(StateEnum.UPLOAD_IMAGE_FAILD);

            }
        }
    }
    @PostMapping("/register")
    public Result registerUser(@RequestParam(name = "username") String username){
          System.out.println(username);
          return ResultUtil.success(StateEnum.USER_SUCCESS,null);
    }

}
