package DB.DBproject.repository;

import DB.DBproject.domain.Product;
import DB.DBproject.domain.User;
import DB.DBproject.domain.User_form_save;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcUserRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcUserRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //create

    public String save(User_form_save userform) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("user").usingGeneratedKeyColumns("user_id");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", userform.getName());
        parameters.put("sex", userform.getSex());
        parameters.put("phone_number", userform.getPhone_number());
        parameters.put("address", userform.getAddress());
        parameters.put("password", userform.getPassword());
        Number key = jdbcInsert.executeAndReturnKey(new
                MapSqlParameterSource(parameters));

        return "저장완료";
    }
    //



    public User findNamePassword(String name,String password) {
        return jdbcTemplate.queryForObject("select * from user where name = ? and password = ? ", userRowMapper(), name,password);
    }




    public String login(String name, String password) {
        int rowCount = this.jdbcTemplate
                .queryForObject("select count(*) from user where name = ? and password = ?", Integer.class, name, password);
        if (rowCount == 0) {
            return "실패";
        } else {
            return "성공";
        }
    }

    private RowMapper<User> userRowMapper() {
        return (rs, rowNum) -> {
            User user = new User();
            user.setUser_id(rs.getInt("user_id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            user.setSex(rs.getString("sex"));
            user.setAddress(rs.getString("address"));
            user.setPhone_number(rs.getString("phone_number"));
            return user;
        };

    }
}