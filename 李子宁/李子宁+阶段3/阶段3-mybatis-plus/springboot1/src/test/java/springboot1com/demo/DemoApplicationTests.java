package springboot1com.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.config.CodeGenerator;
import com.sun.glass.ui.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class DemoApplicationTests {
	@Test
	public void contextLoads() {
		CodeGenerator gse = new CodeGenerator();
		gse.generateByTables(false, "user","book");
	}

}

