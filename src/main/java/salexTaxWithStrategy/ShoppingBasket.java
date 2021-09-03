package salexTaxWithStrategy;


import java.util.HashMap;
import java.util.Map;

public class ShoppingBasket {


    private final Map<Product, Integer> productsWithQty;

    private ShoppingBasket(){
        //todo try dependency injection
        productsWithQty = new HashMap<>();
    }

    public static ShoppingBasket createShoppingBasket() {
        return new ShoppingBasket();
    }


    public void addToBasket(Product product , int quantity) {
        if (product != null && quantity > 0){
            product.tax();
            productsWithQty.put(product , quantity);
        }
        else throw new IllegalArgumentException();
    }


    public Map<Product, Integer> getProductsWithQty() {
        return productsWithQty;
    }
}
