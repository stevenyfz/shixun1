package com.mp.mybatis.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mp.mybatis.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-02-01
 */
public interface IUserService extends IService<User> {


    List<User> selectByUsername();

    List<User> selectBySex();

    Page<User> selectPage();
}
