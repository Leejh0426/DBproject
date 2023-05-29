package DB.DBproject.repository;

import DB.DBproject.domain.Cart;
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

/*
    @Override
    public Cart save(Cart cart) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("cart").usingGeneratedKeyColumns("cart_id");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("cart_id", cart.getCart_id());
        Number key = jdbcInsert.executeAndReturnKey(new
                MapSqlParameterSource(parameters));
        cart.setCart_id(key.intValue());
        return cart;
    }

    @Override
    public Optional<Cart> findById(Long id) {
        List<Cart> result = jdbcTemplate.query("select * from cart where cart_id = ?", cartRowMapper(), id);
        return result.stream().findAny();
    }

*/


    @Override
    public List<Cart> findAll() {
        return jdbcTemplate.query("select * from cart", cartRowMapper());
    }


    private RowMapper<Cart> cartRowMapper() {
        return (rs, rowNum) -> {
            Cart cart = new Cart();
            cart.setCart_id(rs.getInt("cart_id"));
            cart.setProduct_id(rs.getInt("product_id"));
            return cart;
        };
    }
}
