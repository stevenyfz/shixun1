package study.homework2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.homework2.pojo.User;
import study.homework2.service.UserService;

import java.util.List;

@RestController
public class JDBCController {

    @Autowired
    private UserService userService;

    @GetMapping("test")
    public String test(){
        return "hello";
    }

    @GetMapping("insert")
    public void insert(){
        User user = new User();
        user.setName("test");
        this.userService.insert(user);
    }

    @GetMapping("delete")
    public void delete(){
        User user = new User();
        user.setName("test");
        this.userService.delete(user);
    }

    @GetMapping("findAll")
    public List<User> findAll(){
        return this.userService.findAll();
    }

    @GetMapping("find")
    public User findById(){
        System.out.println(this.userService.findById(9));
        return this.userService.findById(9);
    }



}
