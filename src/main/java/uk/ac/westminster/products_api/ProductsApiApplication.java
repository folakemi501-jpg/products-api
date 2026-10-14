package uk.ac.westminster.products_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList; //this is to tell the code to take the list from this package
import java.util.List;

@SpringBootApplication
public class ProductsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsApiApplication.class, args);

		List<Product> products = new ArrayList<>(); //this is like a container to add the elements

		products.add(new Product(1L, "Laptop",999.99)); //this will be added as element 0 to our list
		products.add(new Product(2L, "Mouse",19.9)); //element 1

		System.out.println(products.size());
		System.out.println(products.get(1).getName());

		DigitalProduct ebook = new DigitalProduct(1L, "ebook", 20.99, "download/ld", 50);
		System.out.println(ebook.getName());
	}

}
