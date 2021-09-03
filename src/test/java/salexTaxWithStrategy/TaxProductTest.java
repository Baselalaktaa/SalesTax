package salexTaxWithStrategy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

import salexTaxWithStrategy.products.*;

import java.util.stream.Stream;

class TaxProductTest {


    private static ShoppingBasket basket;

    @BeforeAll
    static void setUp(){
        basket = ShoppingBasket.createShoppingBasket();
    }

    @ParameterizedTest
    @MethodSource("provideGoodsWithoutQty")
    public void taxProductWithoutQty(Product product , float expectedTaxedPrice){
        basket.addToBasket(product , 1);
        assertEquals(expectedTaxedPrice , product.getPriceAfterTax());
        assertThrows(IllegalArgumentException.class , ()-> basket.addToBasket(null ,1));
    }

    @ParameterizedTest
    @MethodSource("provideGoodsWithQty")
    public void taxProductWithQty(Product product , float expectedTaxedPrice , int qty){
        basket.addToBasket(product , qty);

        assertEquals(expectedTaxedPrice * qty , (product.getPriceBeforeTax() + product.getTax()) * qty);
        assertEquals(expectedTaxedPrice  , product.getPriceAfterTax() );

        assertThrows(IllegalArgumentException.class , ()-> basket.addToBasket(null , 0));
        assertThrows(IllegalArgumentException.class , ()-> basket.addToBasket(new Perfume("", 0.0f, true) , -1));
        assertThrows(IllegalArgumentException.class , ()-> basket.addToBasket(null , 1));
    }

    /**
     * the parameters are based on the inputs and outputs from your assignment.
     * @return the parameters to provide
     */
    private static Stream<Arguments> provideGoodsWithoutQty(){
        return Stream.of(
                Arguments.of(
                        new Food("chocolate bar" , 0.85f, false), 0.85f
                ),
                Arguments.of(
                        new Book("lord of the rings", 12.49f , false), 12.49f
                ),
                Arguments.of(
                        new MusicCd("cd", 14.99f, false),16.49f
                ),
                Arguments.of(
                        new Food("imported box of chocolate" , 10.0f, true), 10.5f
                ),
                Arguments.of(
                        new Perfume("imported Perfume" , 47.50f, true), 54.65f
                ),
                Arguments.of(
                        new Perfume("imported Perfume" , 27.99f, true), 32.19f
                ),
                Arguments.of(
                        new Perfume("perfume", 18.99f, false ), 20.89f
                ),
                Arguments.of(
                        new Medicament("pills", 9.75f, false), 9.75f
                ),
                Arguments.of(
                        new Food("imported chocolate", 11.25f, true), 11.85f
                )
        );
    }

    /**
     * the parameters are based on the inputs and outputs from your assignment.
     * @return the parameters to provide
     */
    private static Stream<Arguments> provideGoodsWithQty(){
        return Stream.of(
                Arguments.of(
                        new Food("chocolate bar" , 0.85f, false), 0.85f , 2
                ),
                Arguments.of(
                        new Book("lord of the rings", 12.49f , false), 12.49f , 2
                ),
                Arguments.of(
                        new MusicCd("cd", 14.99f, false),16.49f , 2
                ),
                Arguments.of(
                        new Food("imported box of chocolate" , 10.0f, true), 10.5f , 2
                ),
                Arguments.of(
                        new Perfume("imported Perfume" , 47.50f, true), 54.65f , 2
                ),
                Arguments.of(
                        new Perfume("imported Perfume" , 27.99f, true), 32.19f , 2
                ),
                Arguments.of(
                        new Perfume("perfume", 18.99f, false ), 20.89f , 2
                ),
                Arguments.of(
                        new Medicament("pills", 9.75f, false), 9.75f , 2
                ),
                Arguments.of(
                        new Food("imported chocolate", 11.25f, true), 11.85f ,2
                )
        );
    }
}