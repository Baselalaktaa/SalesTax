package salexTaxWithStrategy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import salexTaxWithStrategy.products.*;

import java.util.stream.Stream;

class ProductTest {

    private static ShoppingBasket basket;
    private static Receipt receipt;
    @BeforeAll
    static void setUp(){
        basket = new ShoppingBasket();
        receipt= new Receipt(basket);
    }

    @ParameterizedTest
    @MethodSource("provideGoods")
    public void taxCalcTest (Product product , float expectedTaxedPrice){
        //todo i dont know yet if this enough, but it tests the tax calculation
        // the test failed now, functions are not implement yet
        basket.addToBasket(product);
        assertEquals(expectedTaxedPrice , product.getPrice());
    }

    /**
     * the parameters are based on the inputs and outputs from your assignment.
     * @return the parameters to provide
     */
    private static Stream<Arguments> provideGoods (){
        return Stream.of(
                Arguments.of(
                        new Food("chocolate bar" , 0.85f, false), 0.85f
                ),
                Arguments.of(
                        new Book("lord of the rings", 12.49f , false), 12.94f
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
}