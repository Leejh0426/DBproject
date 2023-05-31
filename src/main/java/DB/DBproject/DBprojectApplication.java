package DB.DBproject;

import DB.DBproject.repository.JdbcUserRepository;
import DB.DBproject.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DBprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DBprojectApplication.class, args);
	}


}
