package com.Tkk.job.dao;

import com.Tkk.job.entity.PersonInfo;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Author WengWenxin
 * @Date 2019/10/02 23:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonInfoDaoTest {
    @Autowired
    private PersonInfoDao personInfoDao;

    @Test
    public void testQueryPersonInfoById() {
        PersonInfo personInfo = personInfoDao.queryPersonInfoById(1);
        Assert.assertEquals(personInfo.getName(), "翁文鑫");
    }

    @Test
    public void testInsertPersonInfo() {
        PersonInfo personInfo = new PersonInfo();
        personInfo.setName("苏仁杰");
        personInfo.setEmail("8777622@qq.com");
        personInfo.setGender("1");
        personInfo.setCreateTime(new Date());
        personInfo.setLastEditTime(new Date());
        int effectNum = personInfoDao.insertPersonInfo(personInfo);
        Assert.assertEquals(effectNum, 1);
    }

    @Test
    public void testUpdatePersonInfo() {
        PersonInfo personInfo = new PersonInfo();
        personInfo.setName("苏软香");
        personInfo.setUserId(10);
        int effectNum = personInfoDao.updatePersonInfo(personInfo);
        Assert.assertEquals(effectNum, 1);
    }

}
