package com.Tkk.job.service;

import com.Tkk.job.dto.ImageHolder;
import com.Tkk.job.entity.LocalAuth;
import org.springframework.stereotype.Service;

/**
 * @Author WengWenxin
 * @Date 2019/10/04 21:19
 */
public interface LocalAuthService {
    /**
     *@Author WengWenxin
     *@Date 2019/10/4 21:20
     *根据用户名和密码返回用户，用于登录
     */
    LocalAuth getLocalAuthByUsernameAndPwd(String userName, String password,Integer userType);

    void addshopImg(ImageHolder imageHolder);

    Integer registerUser(LocalAuth localAuth);


}
