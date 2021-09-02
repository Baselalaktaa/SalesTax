package salexTaxWithStrategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {

    private List<Product> products;

    public ShoppingBasket (){
        //todo try dependency injection
        products = new ArrayList<>();
    }

    public void addToBasket (Product product) {
        if (product != null){
            product.tax();
            products.add(product);
        }
        else throw new IllegalArgumentException();
    }

    public List<Product> getProducts() {
        return products;
    }
}
