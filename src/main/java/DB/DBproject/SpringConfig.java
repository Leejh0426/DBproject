package DB.DBproject;

import DB.DBproject.repository.CartRepository;
import DB.DBproject.repository.JdbcCartRepository;
import DB.DBproject.repository.JdbcProductRepository;
import DB.DBproject.repository.ProductRepository;
import DB.DBproject.service.CartService;
import DB.DBproject.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }



    @Bean
    public CartService cartService() {
        return new CartService(cartRepository());
    }

    @Bean
    public ProductService productService() {return new ProductService(productRepository()); }


    @Bean
    public CartRepository cartRepository(){
        return new JdbcCartRepository(dataSource);
        // return new JdbcMemberRepository(dataSource);
        //return new JpaMemberRepository(em);
    }

    @Bean
    public ProductRepository productRepository(){
        return new JdbcProductRepository(dataSource);
    }


}
