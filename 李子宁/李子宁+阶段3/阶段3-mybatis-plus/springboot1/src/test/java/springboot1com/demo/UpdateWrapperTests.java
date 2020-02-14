package springboot1com.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.entity.User;
import com.demo.mapper.UserMapper;
import com.test.DemoApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
public class UpdateWrapperTests {
	@Autowired
	private UserMapper usermapper;
	
	//删除测试
	
	@Test
	public void delete() {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.isNull("name").ge("age", 12).isNotNull("uid");
		int delete = usermapper.delete(queryWrapper);
		System.out.println("delete return count = " + delete);
	}
	
	//修改记录
	@Test
	public void update() {
		//修改值
		User user = new User();
		user.setName("张三");
		//修改条件
		UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
		updateWrapper.eq("name","二分");
		
		int update = usermapper.update(user, updateWrapper);
		System.out.println(update);
	}
	

}
