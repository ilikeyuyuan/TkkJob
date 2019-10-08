package com.Tkk.job.dao;

import com.Tkk.job.entity.LocalAuth;
import com.Tkk.job.entity.PersonInfo;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Author WengWenxin
 * @Date 2019/10/02 15:19
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocalAuthDaoTest {
    @Autowired
    private LocalAuthDao localAuthDao;

    @Test
    public void testQueryLocalByUserNameAndPwd() {
        try {
            LocalAuth localAuth = localAuthDao.queryLocalByUserNameAndPwd("lucky", "1020330", 0);
            Assert.assertEquals(localAuth.getUsername(), "lucky");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    @Test
    public void testQueryLocalByUserId() {
        LocalAuth localAuth = localAuthDao.queryLocalByUserId(1);
        Assert.assertEquals(localAuth.getUsername(), "lucky");
    }

    @Test
    public void testInsertLocalAuth() {
        LocalAuth localAuth = new LocalAuth();
        localAuth.setCreateTime(new Date());
        localAuth.setLastEditTime(new Date());
        localAuth.setPassword("1020330");
        localAuth.setUsername("vickey");
        localAuth.setUserType(0);
        int effectNum = localAuthDao.insertLocalAuth(localAuth);
        Assert.assertEquals(effectNum, 1);

    }

    @Test
    public void testUpdateLocalAuth() {
        int effectNum = localAuthDao.updateLocalAuth("vickey", "1020330", "12222", new Date(), 0);
        Assert.assertEquals(effectNum, 1);
    }

    @Test
    public void testIsUserNameExist(){
        LocalAuth localAuth=localAuthDao.isUserNameExist("lucky");
        boolean is=false;
        if(localAuth==null)
            is=true;
        Assert.assertEquals(is,true);
    }


}
