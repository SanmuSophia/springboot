package gcyl.entity.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("gcyl.entity.domain.mapper")
public class Goods {

	public static void main(String[] args) {
		SpringApplication.run(Goods.class, args);
	}
}
