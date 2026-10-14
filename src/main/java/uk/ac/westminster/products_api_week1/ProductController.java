package uk.ac.westminster.products_api_week1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

@RestController //just to find the mapping
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById (@PathVariable Long id) {
        return productService.getProductById(id).orElse(null);
    }

    @GetMapping("/products/search")
    public List<Product> findByName (@RequestParam String name) {
        return productService.findByName(name);
    }

    @PostMapping("/products")
    public Product addProduct (@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @DeleteMapping("/products/{id}") //endpoints that map
    public void deleteProduct (@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
