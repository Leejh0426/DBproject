package DB.DBproject.controller;

import DB.DBproject.domain.Cart;
import DB.DBproject.domain.Product;
import DB.DBproject.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    //장바구니 확인 API
    @GetMapping("/carts/{user_id}")
    public List<Product> list(@PathVariable  int user_id){
        List<Product> carts = cartService.findproductAll(user_id);
        return carts;
    }


    // 장바구니 담기할때 쓰이는 API
    @PostMapping("/carts/{user_id}/{product_id}")
    public String add(@PathVariable int user_id, @PathVariable int product_id){
        return cartService.save(user_id,product_id);
    }



    // 장바구니에서 ID값을 이용해서 삭제하는 API
    @DeleteMapping("/carts/{user_id}/{product_id}")
    public String delete(@PathVariable int user_id, @PathVariable int product_id){
        cartService.deleteproduct_id(user_id,product_id);
        return "삭제완료";
    }




}
