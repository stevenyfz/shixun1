package com.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.entity.User;
import com.demo.entity.Uservo;
import com.demo.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 李小宁
 * @since 2020-02-04
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserMapper usermapper;

	@GetMapping("queryUser")
	public Uservo queryList(Integer current,Integer size) {
		Uservo uservo = new Uservo();
		IPage<User> page = new Page<>();
		usermapper.selectPage(page, null);
		uservo.setCurrent(current);
		uservo.setSize(size);
		uservo.setTotal(page.getTotal());
		uservo.setUserlist(page.getRecords());
		
		
		return uservo;
	}
}

