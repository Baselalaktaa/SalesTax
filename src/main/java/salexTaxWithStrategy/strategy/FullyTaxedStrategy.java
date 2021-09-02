package salexTaxWithStrategy.strategy;

import salexTaxWithStrategy.Product;

/**
 * A strategy to tax products that are not exempted and not imported.
 * @author Basel Alaktaa
 * @since 02.09.2021 20:46
 */
public class FullyTaxedStrategy implements TaxStrategy {
    @Override
    public float taxProduct(Product product) {
        return product.getPrice() * .1f;
    }
}
