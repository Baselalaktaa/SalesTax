package salexTaxWithStrategy.strategy;

import salexTaxWithStrategy.Product;

/**
 * A strategy to tax products that are not exempted and imported.
 * @author Basel Alaktaa
 * @since 02.09.2021 20:44
 */
public class FullyTaxedAndImportedStrategy implements TaxStrategy {
    @Override
    public float taxProduct(Product product) {
        return product.getPrice() * .15f;
    }
}
