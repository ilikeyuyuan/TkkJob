package com.Tkk.job.web.test;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.Tkk.job.config.util.HttpServletRequestUtil;


@CrossOrigin
@Controller
@RequestMapping("/test")
public class TestController {

	@ResponseBody
	@RequestMapping(value = "/testSomething", method = RequestMethod.GET)
	private Map<String, Object> test() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", true);
		modelMap.put("num", 1);
		return modelMap;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> logincheck(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 获取输入的帐号
		String userName = HttpServletRequestUtil.getString(request, "username");
		// 获取输入的密码
		String password = HttpServletRequestUtil.getString(request, "password");
		// 非空校验
		if (userName != null && password != null) {
			
			if(userName.equals("test")&&password.equals("123")) {
				modelMap.put("success", true);
			}
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "用户名和密码均不能为空");
		}
		return modelMap;
	}

}
