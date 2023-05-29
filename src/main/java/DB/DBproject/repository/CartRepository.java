package DB.DBproject.repository;

import DB.DBproject.domain.Cart;

import java.util.List;
import java.util.Optional;

public interface CartRepository {

  //  Cart save(Cart cart);
    //Optional<Cart> findById(Long id);
    List<Cart> findAll();

}
