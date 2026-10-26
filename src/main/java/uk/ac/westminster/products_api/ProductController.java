package uk.ac.westminster.products_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

import static java.lang.IO.println;

@RestController //just to find the mapping
public class ProductController {

    @Autowired //spring creates the product service and hands it over
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        for (Product product : products) {
            System.out.println(product.getSummary()); }
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById (@PathVariable Long id) {
        return productService.getProductById(id).orElse(null);
    }

    @GetMapping("/products/summaries")
    public List<String> getSummaries() { return productService.getAllSummaries(); }

    @GetMapping("/products/search")
    public List<Product> findByName (@RequestParam String name) { return productService.findByName(name); }

    @PostMapping("/products")
    public Product addProduct (@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PostMapping("/product/digital")
    public Product addDigitalProduct(@RequestBody DigitalProduct product) {
        return productService.addProduct(product);
    }

    @DeleteMapping("/products/{id}") //endpoints that map
    public void deleteProduct (@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
