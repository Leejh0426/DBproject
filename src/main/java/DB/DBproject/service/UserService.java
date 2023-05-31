package DB.DBproject.service;

import DB.DBproject.domain.User;
import DB.DBproject.repository.JdbcUserRepository;

public class UserService {

    private final JdbcUserRepository jdbcUserRepository;

    public UserService(JdbcUserRepository jdbcUserRepository) {
        this.jdbcUserRepository = jdbcUserRepository ;
    }

    public String login(String name, String password){
        return jdbcUserRepository.login(name, password);
    }



    public User findNamePassword(String name, String password){
        return jdbcUserRepository.findNamePassword(name,password);
    }
}
