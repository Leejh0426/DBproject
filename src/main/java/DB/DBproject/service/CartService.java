package DB.DBproject.service;

import DB.DBproject.domain.Cart;
import DB.DBproject.domain.Product;
import DB.DBproject.repository.CartRepository;

import java.util.List;
import java.util.Optional;

public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }
/*
    public Optional<Cart> findonebyid(Long memberId){
        return cartRepository.findById(memberId);
    }

 */
    public String save(int id){
        return cartRepository.save(id);
    }

    public List<Product> findproductAll(){
        return cartRepository.findproductAll();
    }


}
