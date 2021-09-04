package salexTaxWithStrategy;

import salexTaxWithStrategy.products.*;
import salexTaxWithStrategy.products.Medicament;
import salexTaxWithStrategy.strategy.*;

/**
 * abstract Product class to represent all products
 * @author Basel Alaktaa
 * @since  02.09.2021 19:00
 * @version 1.0
 */
public abstract class Product implements Taxable {
    private final String name;
    private float priceBeforeTax;
    private float priceAfterTax;
    private final boolean isImported;
    private float tax;
    private TaxStrategy taxStrategy;

    /**
     * added for the products with specific strategy
     * @param name of the product
     * @param priceBeforeTax of the product
     * @param isImported determine if the product is imported to calculate taxes
     * @param taxStrategy for the tax
     */
    public Product (String name , float priceBeforeTax, boolean isImported, TaxStrategy taxStrategy){
        this.name = name;
        this.priceBeforeTax = priceBeforeTax;
        this.isImported = isImported;
        this.taxStrategy = taxStrategy;
    }


    /**
     * for the product with strategy determined by the System
     */
    public Product(String name, float priceBeforeTax, boolean isImported) {
        this (name, priceBeforeTax, isImported, null);
    }

    @Override
    public void tax (){
        if (taxStrategy == null){
            determineStrategy();
        }
        this.setTax(this.roundTax(this.getTaxStrategy().calculateTax(this)));
        this.setPriceAfterTax(this.getTax() + this.getPriceBeforeTax());
    }

    /**
     *
     * @param tax to be rounded
     * @return tax rounded up to the nearest 0.05
     */
    public float roundTax (float tax) {
        return (float) ((float) Math.ceil(tax * 20.0) / 20.0);
    }

    private void determineStrategy () {
        if (this instanceof Food || this instanceof Medicament || this instanceof Book){
            if (!this.isImported()){
                this.setTaxStrategy(new NotTaxedStrategy());
            }
            else {
                this.setTaxStrategy(new ImportedStrategy());
            }
        }
        else {
            if (this.isImported()){
                this.setTaxStrategy(new FullyTaxedAndImportedStrategy());
            }
            else this.setTaxStrategy(new FullyTaxedStrategy());
        }
    }

    public String getName() {
        return name;
    }

    public float getPriceBeforeTax() {
        return priceBeforeTax;
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

    public void setPriceBeforeTax(float priceBeforeTax) {
        this.priceBeforeTax = priceBeforeTax;
    }

    public float getPriceAfterTax() {
        return priceAfterTax;
    }

    public void setPriceAfterTax(float priceAfterTax) {
        this.priceAfterTax = priceAfterTax;
    }
}
