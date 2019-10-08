package com.Tkk.job.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.Tkk.job.entity.LocalAuth;
import org.springframework.stereotype.Component;

@Component
public interface LocalAuthDao {

	/**
	 * 通过帐号和密码查询对应信息，登录用
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	LocalAuth queryLocalByUserNameAndPwd(@Param("username") String username, @Param("password") String password,@Param("userType") Integer userType);

	/**
	 * 通过用户Id查询对应localauth
	 * 
	 * @param userId
	 * @return
	 */
	LocalAuth queryLocalByUserId(@Param("userId") Integer userId);

	/**
	 * 添加平台帐号
	 * 
	 * @param localAuth
	 * @return
	 */
	int insertLocalAuth(LocalAuth localAuth);

	/**
	 * 通过userId,username,password更改密码
	 * 
	 * @param
	 * @return
	 */
	int updateLocalAuth(@Param("username") String username,
			@Param("password") String password, @Param("newPassword") String newPassword,
			@Param("lastEditTime") Date lastEditTime,@Param("userType") Integer userType);

	/**
	 *@Author WengWenxin
	 *@Date 2019/10/6 19:55
	 * 注册用，用于判断是否已存在用户名
	 */
	LocalAuth isUserNameExist(@Param("username") String username);
}