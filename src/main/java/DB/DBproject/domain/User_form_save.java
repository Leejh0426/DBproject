package DB.DBproject.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User_form_save {

    private int password;
    private String name;
    private String sex;
    private String phone_number;
    private String address;
}
