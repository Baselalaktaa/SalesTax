package salexTaxWithStrategy;

import java.time.Instant;
import java.util.Date;
import java.util.Map;

/**
 * to represent the receipt
 * @author Basel Alaktaa
 * @since 02.09.2021 20:21
 */
public class Receipt {

    private final static String NEW_LINE = "\n";
    private final ShoppingBasket shoppingBasket;
    private float totalPrice;
    private float applicableTax;
    private StringBuilder receipt;


    private Receipt(ShoppingBasket shoppingBasket){
        this.shoppingBasket = shoppingBasket;
    }

    public static Receipt createReceipt(ShoppingBasket shoppingBasket) {
        return new Receipt(shoppingBasket);
    }

    public void prepareReceipt () {
        receipt = new StringBuilder();
        Map<Product , Integer> productsWithQty = shoppingBasket.getProductsWithQty();


        final Date now = Date.from(Instant.now());
        receipt.append("Date: ").append(now).append(NEW_LINE);
        receipt.append("thanks for your order, details: ").append(NEW_LINE);


        for (Map.Entry<Product ,Integer> entry : productsWithQty.entrySet()){

            totalPrice = totalPrice + entry.getKey().getPriceAfterTax() * entry.getValue();
            applicableTax = applicableTax + entry.getKey().getTax() * entry.getValue();

            receipt.append(entry.getKey().getName())
                    .append(" #Qty: ").append(entry.getValue())
                    .append(" #net price: ").append(entry.getKey().getPriceBeforeTax() * entry.getValue())
                    .append(" #taxed price: ").append(entry.getKey().getPriceAfterTax() * entry.getValue())
                    .append(NEW_LINE);
        }
        receipt.append("-----------------------------------------------")
                .append(NEW_LINE)
                .append("tax: ").append(applicableTax).append(NEW_LINE)
                .append("total: ").append(totalPrice);
    }

    @Override
    public String toString (){
        return receipt.toString();
    }


    public float getApplicableTax() {
        return applicableTax;
    }
}
