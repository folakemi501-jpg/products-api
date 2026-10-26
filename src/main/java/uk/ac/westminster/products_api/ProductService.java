package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>(); //the products allow to add all the children class
    private Long nextId = 1L; //remembers which id to hand out next

    public ProductService() { //this means it gets digital and physical products saved in a list of product
        products.add(new DigitalProduct(nextId++, "clean code(E-book)", 29.99,"/download/clean-code/",4.2));
        products.add(new PhysicalProduct(nextId++,"27-inch Monitor", 249.99, 5.4, "61cm x 41cm x 18cm" ));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public List<String> getAllSummaries() {
        List<String> summaries = new ArrayList<>();
        for (Product product : products) {
            summaries.add(product.getSummary()); }
        return summaries;
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
