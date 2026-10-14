package uk.ac.westminster.products_api;

public class Product {
    private Long id;
    private String name;
    private double price;

    public Product() {} //this is an empty constructor with no arguments required by Jackson

    public Product (Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() { return id; } //these are methods that return the specific attributes from the feilds
    public String getName() { return name; } //we use these for  jackson to find something to call for the JSON
    public double getPrice() { return price; }

    public void setId(Long id) { this.id = id; } //service will call this to number each new product
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
}
