package salexTaxWithStrategy.strategy;

import salexTaxWithStrategy.Product;

/**
 * A strategy to tax products that are not exempted and imported.
 * @author Basel Alaktaa
 * @since 02.09.2021 20:44
 */
public class FullyTaxedAndImportedStrategy implements TaxStrategy {
    @Override
    public float determineTaxStrategy(Product product) {
        return product.getPriceBeforeTax() * .15f;
    }
}
