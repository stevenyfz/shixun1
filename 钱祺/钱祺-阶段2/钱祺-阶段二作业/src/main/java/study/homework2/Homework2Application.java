package study.homework2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("study.homework2.mapper")
public class Homework2Application {
    public static void main(String[] args) {
        SpringApplication.run(Homework2Application.class);
    }
}
