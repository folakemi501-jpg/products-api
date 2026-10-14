package uk.ac.westminster.products_api;

public class DigitalProduct extends Product{
    //instance attribute
    private String downloadUrl;
    private double fileSizeMB;

    public DigitalProduct() {}

    public DigitalProduct(Long id, String name, double price, String downloadUrl, double fileSizeMB) {
        super(id, name, price); //accessed and set this  through the parent class
        this.downloadUrl = downloadUrl; //constructors
        this.fileSizeMB = fileSizeMB;
    }

    public String getDownloadUrl() { return downloadUrl; }
    public double getFileSizeMB() { return fileSizeMB; }
}
