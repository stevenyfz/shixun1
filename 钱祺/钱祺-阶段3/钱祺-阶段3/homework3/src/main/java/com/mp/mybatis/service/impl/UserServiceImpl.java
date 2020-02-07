package com.mp.mybatis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mp.mybatis.entity.User;
import com.mp.mybatis.mapper.UserMapper;
import com.mp.mybatis.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-02-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public List<User> selectByUsername() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", "修改");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.allEq(map, false);
        return userMapper.selectList(wrapper);
    }

    @Override
    public List<User> selectBySex() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("sex", "男");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.allEq(map, false);
        return userMapper.selectBySex(wrapper);
    }

    @Override
    public Page<User> selectPage() {
        Page<User> page = new Page<>(1,2);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        return userMapper.selectPage(page, wrapper);
    }
}
