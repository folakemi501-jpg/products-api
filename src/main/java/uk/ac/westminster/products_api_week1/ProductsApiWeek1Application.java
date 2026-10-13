package uk.ac.westminster.products_api_week1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList; //this is to tell the code to take the list from this package
import java.util.List;

@SpringBootApplication
public class ProductsApiWeek1Application {

	public static void main(String[] args) {
		SpringApplication.run(ProductsApiWeek1Application.class, args);

		List<Product> products = new ArrayList<>(); //this is like a container to add the elements

		products.add(new Product(1L, "Laptop",999.99)); //this will be added as element 0 to our list
		products.add(new Product(2L, "Mouse",19.9)); //element 1

		System.out.println(products.size());
		System.out.println(products.get(1).getName());
		System.out.println(products.remove(1));
		System.out.println(products.size());
	}
}
