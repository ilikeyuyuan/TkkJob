package com.Tkk.job.service.impl;

import com.Tkk.job.config.util.PathUtil;
import com.Tkk.job.config.util.ImageUtil;
import com.Tkk.job.dao.LocalAuthDao;
import com.Tkk.job.dto.ImageHolder;
import com.Tkk.job.entity.LocalAuth;
import com.Tkk.job.enums.StateEnum;
import com.Tkk.job.exceptions.MyException;
import com.Tkk.job.service.LocalAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author WengWenxin
 * @Date 2019/10/04 21:23
 */
@Service
public class LocalAuthServiceImpl implements LocalAuthService {

    @Autowired
    private LocalAuthDao localAuthDao;
    @Override
    public LocalAuth getLocalAuthByUsernameAndPwd(String userName, String password, Integer userType) {
        return localAuthDao.queryLocalByUserNameAndPwd(userName,password,userType);
    }

    @Override
    public void addshopImg(ImageHolder imageHolder) {
        // 获取User图片目录的相对值路径
        String dest = PathUtil.getShopImagePath(1);
        String shopImgAddr = ImageUtil.generateThumbnail(imageHolder, dest);
    }

    @Override
    public Integer registerUser(LocalAuth localAuth) {
        if(localAuthDao.isUserNameExist(localAuth.getUsername())!=null)
            throw new MyException(StateEnum.USERNAME_ISEXIST);
        return localAuthDao.insertLocalAuth(localAuth);

    }
}
