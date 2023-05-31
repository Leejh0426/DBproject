package DB.DBproject.repository;

import DB.DBproject.domain.Cart;
import DB.DBproject.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class JdbcCartRepository implements CartRepository{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcCartRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public String save(int user_id, int product_id) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("cart").usingGeneratedKeyColumns("cart_id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("product_id", product_id);
        parameters.put("user_id", user_id);
        Number key = jdbcInsert.executeAndReturnKey(new
                MapSqlParameterSource(parameters));

        return "저장완료";
    }
/*
    @Override
    public Optional<Cart> findById(Long id) {
        List<Cart> result = jdbcTemplate.query("select * from cart where cart_id = ?", cartRowMapper(), id);
        return result.stream().findAny();
    }

*/


    //장바구니에 담긴 product의 정보를 꺼내온다.
    @Override
    public List<Product> findproductAll(int user_id) {
        return jdbcTemplate.query("select p.product_id, p.name, p.price, p.image from cart c, product p where c.product_id = p.product_id and c.user_id = ? ", productRowMapper(), user_id);
    }

    //product_id를 넘겨받고 그거랑 일치하는 자료를 삭제해준다.

    @Override
    public void delete(int user_id, int product_id){
        this.jdbcTemplate.update(
                "delete from cart where user_id = ? and product_id = ?", Integer.valueOf(user_id),Integer.valueOf(product_id));

    }




    private RowMapper<Product> productRowMapper() {
        return (rs, rowNum) -> {
            Product product = new Product();
            product.setProduct_id(rs.getInt("product_id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getInt("price"));
            product.setImage(rs.getString("Image"));
            return product;
        };
    }
}
