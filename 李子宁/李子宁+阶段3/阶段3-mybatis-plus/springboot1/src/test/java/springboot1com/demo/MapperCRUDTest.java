package springboot1com.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.entity.User;
import com.demo.entity.Uservo;
import com.demo.mapper.UserMapper;
import com.test.DemoApplication;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
public class MapperCRUDTest {
	@Autowired
	private UserMapper usermapper;
	@Test
	//增加数据测试
	public void insert() {
		User user = new User();
		user.setName("模式");
		Integer insert = usermapper.insert(user);
		System.out.println("return insert value = " + insert);
	}
		
	//删除数据测试
	@Test
	public void deleteById() {
		Integer deleteById = usermapper.deleteById(2);
	}
	
	//查询数据测试
	@Test
	public void selectByIdLoads() {
		User user = usermapper.selectById(3);
		System.out.println("查询的数据是：" + user);
	}
	
	//修改数据测试
	@Test
	public void updataByIdLoads() {
		User user = new User();
		user.setAge(18);
		user.setName("打工行");
		user.setUid(1);
		Integer insert = usermapper.updateById(user);
		System.out.println("修改的数据:" + insert);
	}
	
	//分页查询
	@Test
	public void queryUserByPage() {
		IPage<User> userpage = new Page<>(1,5);
		userpage = usermapper.selectPage(userpage, null);
		List<User> list = userpage.getRecords();
		for(User user: list) {
			System.out.println(user);
		}
		
	}
}
