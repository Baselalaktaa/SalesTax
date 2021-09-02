package salexTaxWithStrategy;

public abstract class Product {
    private String name;
    private float price;
    private boolean isImported;
    private float tax;


    public Product(String name, float price, boolean isImported) {
        this.name = name;
        this.price = price;
        this.isImported = isImported;
    }
}
