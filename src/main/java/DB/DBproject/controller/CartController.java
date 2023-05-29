package DB.DBproject.controller;

import DB.DBproject.domain.Cart;
import DB.DBproject.domain.Product;
import DB.DBproject.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<Product> list(){
        List<Product> carts = cartService.findproductAll();
        return carts;
    }

    @PostMapping("/carts")
    public String add(@RequestParam int id){
        return cartService.save(id);
    }






}
