package com.mp.mybatis.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mp.mybatis.entity.User;
import com.mp.mybatis.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-02-01
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;


    /**
     * CRUD
     */
    @GetMapping("/select")
    public List<User> selectAll(){
        return userService.list();
    }

    @GetMapping("/insert")
    public Boolean insert(){
        User user = new User();
        user.setUsername("test");
        return userService.save(user);

    }

    @GetMapping("/update")
    public Boolean update(){
        User user = new User();
        user.setId(48);
        user.setUsername("修改");
        return userService.updateById(user);

    }

    @GetMapping("/delete/{id}")
    public Boolean delete(@PathVariable("id") Integer id){

        return userService.removeById(id);
    }

    /**
     * 条件查询
     */
    @GetMapping("/selectByUsername")
    public List<User> selectByUsername(){

        return userService.selectByUsername();


    }

    /**
     * 自定义
     */

    @GetMapping("/selectBySex")
    public List<User> selectBySex(){
        return userService.selectBySex();

    }

    /**
     * 分页
     */
    @GetMapping("/page")
    public Page<User> page(){
        return userService.selectPage();
    }



}
