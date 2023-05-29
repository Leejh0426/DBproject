package DB.DBproject.repository;

import DB.DBproject.domain.Cart;
import DB.DBproject.domain.Product;

import java.util.List;
import java.util.Optional;

public interface CartRepository {

    String save(int id);
    //Optional<Cart> findById(Long id);
    List<Product> findproductAll();
 //   Optional<Cart> saveById(int id);

}
