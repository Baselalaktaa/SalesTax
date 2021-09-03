package salexTaxWithStrategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import salexTaxWithStrategy.products.Book;
import salexTaxWithStrategy.products.Food;
import salexTaxWithStrategy.products.Perfume;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {


    private ShoppingBasket shoppingBasket;
    private Receipt receipt;

    @BeforeEach
    public void setUp (){
        shoppingBasket = ShoppingBasket.createShoppingBasket();
        receipt = Receipt.createReceipt(shoppingBasket);
    }

    @Test
    public void receiptTest () {
        Product perfume = new Perfume("imported Perfume" , 47.50f, true);
        Product importedChoco = new Food("imported box of chocolate" , 10.0f, true);
        Product book = new Book("lord of the rings", 12.49f , false);

        shoppingBasket.addToBasket(perfume , 1);
        shoppingBasket.addToBasket(importedChoco ,2);
        shoppingBasket.addToBasket(book, 3);

        receipt.prepareReceipt();

        float expectedTax = 0.0f;
        for (Map.Entry<Product , Integer> entry : shoppingBasket.getProductsWithQty().entrySet()){
            expectedTax = expectedTax + entry.getKey().getTax() * entry.getValue();
        }

        assertEquals(expectedTax , receipt.getApplicableTax());

    }
}