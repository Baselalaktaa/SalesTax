package salexTaxWithStrategy;

import salexTaxWithStrategy.strategy.TaxStrategy;

public abstract class Product  {
    private String name;
    private float price;
    private boolean isImported;
    private float tax;
    private TaxStrategy taxStrategy;


    public Product(String name, float price, boolean isImported) {
        this.name = name;
        this.price = price;
        this.isImported = isImported;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public boolean isImported() {
        return isImported;
    }

    public float getTax() {
        return tax;
    }

    public TaxStrategy getTaxStrategy() {
        return taxStrategy;
    }
}
