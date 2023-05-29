package DB.DBproject.repository;

import DB.DBproject.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    /*
    Product save(Product product);

    Optional<Product> findByName(String name);
    */

    List<Product> findAll();


}
