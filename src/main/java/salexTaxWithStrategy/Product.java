package salexTaxWithStrategy;

import salexTaxWithStrategy.strategy.TaxStrategy;

/**
 * abstract Product class to represent all products
 * @author Basel Alaktaa
 * @since  02.09.2021 19:00
 * @version 1.0
 */
public abstract class Product implements Taxable {
    private final String name;
    private final float price;
    private final boolean isImported;
    private float tax;
    private TaxStrategy taxStrategy;

    /**
     * added for the products with specific strategy
     * @param name of the product
     * @param price of the product
     * @param isImported determine if the product is imported to calculate taxes
     * @param taxStrategy for the tax
     */
    public Product (String name , float price , boolean isImported, TaxStrategy taxStrategy){
        this.name = name;
        this.price = price;
        this.isImported = isImported;
        this.taxStrategy = taxStrategy;
    }


    /**
     * for the product with strategy
     */
    public Product(String name, float price, boolean isImported) {
        this (name, price , isImported, null);
    }

    @Override
    public void tax (){
        //todo execute the tax strategy to tax a product
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

    public void setTax(float tax) {
        this.tax = tax;
    }

    public void setTaxStrategy(TaxStrategy taxStrategy) {
        this.taxStrategy = taxStrategy;
    }
}
