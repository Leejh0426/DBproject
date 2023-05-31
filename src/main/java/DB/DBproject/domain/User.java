package DB.DBproject.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int user_id;
    private String name;
    private String password;
    private String sex;
    private String phone_number;
    private String address;

}
