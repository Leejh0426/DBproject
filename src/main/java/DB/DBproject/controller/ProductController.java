package DB.DBproject.controller;

import DB.DBproject.domain.Cart;
import DB.DBproject.domain.Product;
import DB.DBproject.service.CartService;
import DB.DBproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }



    //모든 product 열을 들고 와주는 API(첫페이지에사용)
    @GetMapping("/products")
    public List<Product> list(){
        List<Product> products = productService.findProducts();
        return products;
    }

}
