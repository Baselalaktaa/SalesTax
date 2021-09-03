package salexTaxWithStrategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {

    private final List<Product> products;

    public ShoppingBasket (){
        //todo try dependency injection
        products = new ArrayList<>();
    }


    public void addToBasket (Product product ) {
        if (product != null){
            product.tax();
            products.add(product);
        }
        else throw new IllegalArgumentException();
    }

    public void addToBasketWithQty (Product product , int quantity) {
        //todo implement
    }

    public List<Product> getProducts() {
        return products;
    }
}
