package salexTaxWithStrategy;

import java.util.Date;

/**
 * to represent the receipt
 * @author Basel Alaktaa
 * @since 02.09.2021 20:21
 */
public class Receipt {

    private ShoppingBasket shoppingBasket;
    private float totalPrice;
    private float applicableTax;
    private Date receiptDate;

    public Receipt (ShoppingBasket shoppingBasket){
        this.shoppingBasket = shoppingBasket;
    }
    @Override
    public String toString (){
        //todo the receipt as a simple String
        return null;
    }
}
