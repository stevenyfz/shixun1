package com.how2java.springboot.web;
import java.text.DateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 /*这个类就是Spring MVC里的一个普通的控制器。
@RestController 是spring4里的新注解，是@ResponseBody和@Controller的缩写。*/
//@RestController  用这个在类上方，运行时候会返回字符串


/*把本来的@RestController 改为@Controller。
这时返回"hello"就不再是字符串，而是根据application.properties 
中的视图重定向，到/WEB-INF/jsp目录下去寻找hello.jsp文件*/

@Controller
public class HelloController {
 

 /*     @RequestMapping("/hello") 
  *  public String hello() {
        return "Hello Spring Boot!";
    }
 */
	/*
    @RequestMapping("/hello")//运行后可以访问hellow.jsp
    public String hello(Model m) {
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return "hello";
    }
    */
	
	//错误处理那一章的
	@RequestMapping("/hello")
    public String hello(Model m) throws Exception {
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        if(true){
            throw new Exception("some exception");
        }
        return "hello";
    }
}