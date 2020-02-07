package com.mp;

import com.mp.mybatis.mapper.UserMapper;
import com.mp.mybatis.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class test {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Test
    public void select(){
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(7, userList.size());
        userList.forEach(user -> System.out.println(user));
    }


}
