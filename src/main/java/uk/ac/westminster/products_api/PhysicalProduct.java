package uk.ac.westminster.products_api;

public class PhysicalProduct extends Product implements Discountable {

    private double weightKg;
    private String dimensions;
    private double discountedPrice;

    public PhysicalProduct() {}

    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    @Override //provides a method with a behavior
    public String getSummary() { return "Physical: " + getName() + " | " + getWeightKg() + "kg";}

    @Override
    public void applyDiscount(double rate) {
        double capped = Math.min(rate,0.20);
        discountedPrice = getPrice() * (1 - capped);}

    @Override
    public double getDiscountedPrice() { return discountedPrice; }

    public double getWeightKg() { return weightKg; }
    public String getDimensions() { return dimensions; }
}
