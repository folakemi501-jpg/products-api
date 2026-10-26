package uk.ac.westminster.products_api;

public class DigitalProduct extends Product implements Discountable {

    private String downloadUrl;
    private double fileSizeMB;
    private double discountedPrice;

    public DigitalProduct() {} //for Jackson

    public DigitalProduct(Long id, String name, double price, String downloadUrl, double fileSizeMB) {
        super(id, name, price); //accessed and set this through the parent class
        this.downloadUrl = downloadUrl; //constructors
        this.fileSizeMB = fileSizeMB;
    }

    @Override //added this because we have the same method in parent class
    public String getSummary() { return "Digital: " + getName() + " | Download: "+ getDownloadUrl(); }

    @Override
    public void applyDiscount(double rate) { discountedPrice = getPrice() * (1 - rate);}

    @Override
    public double getDiscountedPrice() { return discountedPrice;}

    public String getDownloadUrl() { return downloadUrl; }
    public double getFileSizeMB() { return fileSizeMB; }
}
