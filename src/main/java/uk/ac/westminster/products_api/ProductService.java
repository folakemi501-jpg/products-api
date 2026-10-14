package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L; //remembers which id to hand out next

    public List<Product> getAllProducts() {
        return products;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    public List<Product> findByName(String name) {
        return products.stream().filter(product -> product.getName().contains(name)).toList();
    }

    public void deleteProduct (Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    public Product addProduct(Product product) {
        product.setId(nextId++); //business rule which will use the value, then add one
        products.add(product); //data storage that stores an object into our collection
        return product; //HTTP response
    }
}
