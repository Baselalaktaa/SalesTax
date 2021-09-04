package salexTaxWithStrategy;

import salexTaxWithStrategy.helpers.DataExporter;
import salexTaxWithStrategy.products.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("####### OUTPUT 1");
        ShoppingBasket basket1 = ShoppingBasket.createShoppingBasket();
        Food chocolate = new Food("chocolate" ,0.85f, false);
        MusicCd musicCd = new MusicCd("cd", 14.99f, false );
        Book book = new Book("book", 12.49f, false );

        basket1.addToBasket(chocolate , 1);
        basket1.addToBasket(musicCd , 1);
        basket1.addToBasket(book , 1);

        Receipt receipt1 = Receipt.createReceipt(basket1);
        receipt1.prepareReceipt();
        System.out.println(receipt1);
        /*
        output 2
         */
        System.out.println();
        System.out.println("####### OUTPUT2");

        ShoppingBasket basket2 = ShoppingBasket.createShoppingBasket();

        Food importedChocolate2 = new Food("milka" ,10.00f, true);
        Perfume importedPerfume2 = new Perfume("Gucci", 47.50f, true);

        basket2.addToBasket(importedChocolate2 , 1);
        basket2.addToBasket(importedPerfume2 , 1);

        Receipt receipt = Receipt.createReceipt(basket2);
        receipt.prepareReceipt();
        System.out.println(receipt);

        /*
        output 3
         */
        System.out.println();
        System.out.println("####### OUTPUT 3");
        ShoppingBasket basket3 = ShoppingBasket.createShoppingBasket();
        Food importedChocolate = new Food("milka" ,11.25f, true);
        Perfume importedPerfume = new Perfume("Gucci", 27.99f, true);
        Perfume perfume = new Perfume("Gucci", 18.99f, false );
        Medicament pills = new Medicament("pills" , 9.75f, false);

        basket3.addToBasket(importedChocolate , 1);
        basket3.addToBasket(importedPerfume, 1);
        basket3.addToBasket(perfume , 1);
        basket3.addToBasket(pills , 1);

        Receipt receipt3 = Receipt.createReceipt(basket3);
        receipt3.prepareReceipt();

        DataExporter dataExporter = DataExporter.createDataExporter(receipt3);

        dataExporter.exportToPdf();

        System.out.println(receipt3);
    }
}
