package DB.DBproject.repository;

import DB.DBproject.domain.Cart;
import DB.DBproject.domain.Product;

import java.util.List;
import java.util.Optional;

public interface CartRepository {

    String save(int user_id, int product_id);
    //Optional<Cart> findById(Long id);
    public List<Product> findproductAll(int user_id);
 //   Optional<Cart> saveById(int id);

    public void delete(int user_id, int product_id);
}
