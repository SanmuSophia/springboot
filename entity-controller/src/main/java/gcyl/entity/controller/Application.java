package gcyl.entity.controller;

import com.didispace.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableSwagger2Doc
@MapperScan("gcyl.entity.domain.mapper")
@ComponentScan(basePackages = "gcyl.entity")
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
