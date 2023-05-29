package DB.DBproject.controller;

import DB.DBproject.domain.Cart;
import DB.DBproject.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    @GetMapping("/carts")
    public List<Cart> list(){
        List<Cart> carts = cartService.findCarts();
        return carts;
    }




}
