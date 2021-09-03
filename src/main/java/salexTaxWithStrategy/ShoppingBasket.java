package salexTaxWithStrategy;


import java.util.HashMap;
import java.util.Map;

public class ShoppingBasket {


    private final Map<Product, Integer> productsWithQty;

    public ShoppingBasket (){
        //todo try dependency injection
        productsWithQty = new HashMap<>();
    }



    public void addToBasket(Product product , int quantity) {
        if (product != null && quantity > 0){
            product.tax();
            product.setPriceBeforeTax(product.getPriceBeforeTax() * quantity);
            product.setPriceAfterTax(product.getPriceAfterTax() * quantity);
            productsWithQty.put(product , quantity);
        }
        else throw new IllegalArgumentException();
    }


    public Map<Product, Integer> getProductsWithQty() {
        return productsWithQty;
    }
}
