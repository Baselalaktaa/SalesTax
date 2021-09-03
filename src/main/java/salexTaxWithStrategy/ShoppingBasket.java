package salexTaxWithStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingBasket {

    private final List<Product> products;
    private final Map<Product, Integer> productsWithQty;

    public ShoppingBasket (){
        //todo try dependency injection
        products = new ArrayList<>();
        productsWithQty = new HashMap<>();
    }


    public void addToBasket (Product product ) {
        if (product != null){
            product.tax();
            products.add(product);
        }
        else throw new IllegalArgumentException();
    }

    public void addToBasketWithQty (Product product , int quantity) {
        if (product != null && quantity > 0){
            product.tax();
            product.setPrice(product.getPrice() * quantity);
            productsWithQty.put(product , quantity);
        }
        else throw new IllegalArgumentException();
    }

    public List<Product> getProducts() {
        return products;
    }
}
