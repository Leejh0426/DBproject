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
    public String save(int user_id, int product_id){
        return cartRepository.save(user_id, product_id);
    }

    public List<Product> findproductAll(int user_id){
        return cartRepository.findproductAll(user_id);
    }


    public void deleteproduct_id(int user_id, int product_id){
        cartRepository.delete(user_id, product_id);
    }

}
