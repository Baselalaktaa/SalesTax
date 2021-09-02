package salexTaxWithStrategy;

import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * to represent the receipt
 * @author Basel Alaktaa
 * @since 02.09.2021 20:21
 */
public class Receipt {

    private final ShoppingBasket shoppingBasket;
    private float totalPrice;
    private float applicableTax;
    private StringBuilder result;

    private final static String NEW_LINE = "\n";


    public Receipt (ShoppingBasket shoppingBasket){
        this.shoppingBasket = shoppingBasket;
    }

    public void prepareReceipt () {
        result = new StringBuilder();
        List<Product> products = shoppingBasket.getProducts();

        final Date now = Date.from(Instant.now());
        result.append("Date: ").append(now).append(NEW_LINE);
        result.append("thanks for your order, details: ").append(NEW_LINE);

        for (Product product : products){
            totalPrice = totalPrice + product.getPrice();
            applicableTax = applicableTax + product.getTax();
            result.append(product.getName()).append(" # price: ")
                    .append(product.getPrice()).append(NEW_LINE);
        }
        result.append("-----------------------------------------------")
                .append(NEW_LINE)
                .append("tax: ").append(applicableTax).append(NEW_LINE)
                .append("total: ").append(totalPrice);
    }

    @Override
    public String toString (){
        return result.toString();
    }
}
