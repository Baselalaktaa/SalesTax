package salexTaxWithStrategy;

import salexTaxWithStrategy.products.*;

public class main {
    public static void main(String[] args) {
        System.out.println("####### OUTPUT 1");
        ShoppingBasket basket1 = new ShoppingBasket();
        Food chocolate = new Food("chocolate" ,0.85f, false);
        MusicCd musicCd = new MusicCd("cd", 14.99f, false );
        Book book = new Book("book", 12.49f, false );

        basket1.addToBasket(chocolate);
        basket1.addToBasket(musicCd);
        basket1.addToBasket(book);

        Receipt receipt1 = Receipt.createReceipt(basket1);
        receipt1.prepareReceipt();
        System.out.println(receipt1);
        /*
        output 2
         */
        System.out.println();
        System.out.println("####### OUTPUT2");

        ShoppingBasket basket2 = new ShoppingBasket();

        Food importedChocolate2 = new Food("milka" ,10.00f, true);
        Perfume importedPerfume2 = new Perfume("Gucci", 47.50f, true);

        basket2.addToBasket(importedChocolate2);
        basket2.addToBasket(importedPerfume2);

        Receipt receipt = Receipt.createReceipt(basket2);
        receipt.prepareReceipt();
        System.out.println(receipt);

        /*
        output 3
         */
        System.out.println();
        System.out.println("####### OUTPUT 3");
        ShoppingBasket basket3 = new ShoppingBasket();
        Food importedChocolate = new Food("milka" ,11.25f, true);
        Perfume importedPerfume = new Perfume("Gucci", 27.99f, true);
        Perfume perfume = new Perfume("Gucci", 18.99f, false );
        Medicament pills = new Medicament("pills" , 9.75f, false);

        basket3.addToBasket(importedChocolate);
        basket3.addToBasket(importedPerfume);
        basket3.addToBasket(perfume);
        basket3.addToBasket(pills);

        Receipt receipt3 = Receipt.createReceipt(basket3);
        receipt3.prepareReceipt();

        System.out.println(receipt3);
    }
}
