package salexTaxWithStrategy;

import salexTaxWithStrategy.products.Book;
import salexTaxWithStrategy.products.Food;
import salexTaxWithStrategy.products.MusicCd;

public class main {
    public static void main(String[] args) {
        System.out.println("########### input 1");
        System.out.println("####### OUTPUT 1");
        ShoppingBasket basket1 = new ShoppingBasket();
        Food chocolate = new Food("chocolate" ,0.85f, false);
        MusicCd musicCd = new MusicCd("cd", 14.99f, false );
        Book book = new Book("book", 12.49f, false );

        basket1.addToBasket(chocolate);
        basket1.addToBasket(musicCd);
        basket1.addToBasket(book);

        Receipt receipt1 = new Receipt(basket1);
        receipt1.prepareReceipt();
        System.out.println(receipt1);
    }
}
