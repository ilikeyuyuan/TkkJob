package com.Tkk.job.dao;

import com.Tkk.job.entity.PersonInfo;
import org.springframework.stereotype.Component;

@Component
public interface PersonInfoDao {
	/**
	 * 通过用户Id查询用户
	 */

	PersonInfo queryPersonInfoById(Integer userId);
	
	/**
	 * 添加用户信息
	 */
	int insertPersonInfo(PersonInfo personInfo);

	/**
      修改用户信息
	 */
	int updatePersonInfo(PersonInfo personInfo);
}
