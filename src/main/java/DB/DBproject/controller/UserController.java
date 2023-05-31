package DB.DBproject.controller;

import DB.DBproject.domain.User;
import DB.DBproject.service.CartService;
import DB.DBproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    // 처음에 login 할때 API
    @PostMapping("/user/{name}/{password}")
    public String login(@PathVariable String name, @PathVariable String password){
        return userService.login(name,password);

    }

    // 유저 상세정보 띄우는 API
    @GetMapping("/user/{name}/{password}")
    public User information(@PathVariable String name, @PathVariable String password){
        return userService.findNamePassword(name,password);
    }

    //유저 상세정보에서 업데이트 API
    @PutMapping("/user/{user}")
    public User updateForm(@PathVariable User user){
        return userService.updateForm(user);
    }




}
