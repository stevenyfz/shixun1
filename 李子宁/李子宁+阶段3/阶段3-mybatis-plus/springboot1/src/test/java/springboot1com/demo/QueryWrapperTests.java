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
public class QueryWrapperTests {
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
	
	
	//查询测试
	@Test
	public void selectOne() {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("name", "二分");
		
		User user = usermapper.selectOne(queryWrapper);
		System.out.println(user);
	}
	
	//根据条件，查询总记录数
	@Test
	public void selectCount() {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("name", "二分");
		
		Integer count = usermapper.selectCount(queryWrapper);
		System.out.println(count);
	}
	
	//根据条件查询全部记录，并翻页
	@Test
	public void selectPage() {
		Page<User> page = new Page<>(1,5);
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		
		IPage<User> userIPage = usermapper.selectPage(page, queryWrapper);
		System.out.println(userIPage);
	}
	

}
