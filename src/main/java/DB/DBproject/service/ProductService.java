package DB.DBproject.service;

import DB.DBproject.domain.Cart;
import DB.DBproject.domain.Product;
import DB.DBproject.repository.ProductRepository;

import java.util.List;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findProducts(){
        return productRepository.findAll();
    }

}
