package DB.DBproject.repository;

import DB.DBproject.domain.Cart;
import DB.DBproject.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class JdbcProductRepository implements ProductRepository{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcProductRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query("select * from product", productRowMapper());
    }




    private RowMapper<Product> productRowMapper() {
        return (rs, rowNum) -> {
            Product product = new Product();
            product.setProduct_id(rs.getInt("product_id"));
            product.setName(rs.getString("name"));
            product.setImage(rs.getString("image"));
            product.setPrice(rs.getInt("price"));
            return product;
        };
    }



}
