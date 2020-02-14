package springboot1com.demo;


import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.entity.User;
import com.demo.service.UserService;
import com.test.DemoApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
public class ServiceCRUDTest {
	@Autowired
	@Resource(name="UserService")
	private UserService userservice;
	
	//查找测试
	@Test
	public void selectById() {
		User user = new User();
		user.setUid(Integer.parseInt(UUID.randomUUID().toString()));
		user.setName("狗剩");
		boolean b = userservice.save(user);
		
		
	
	}

}
