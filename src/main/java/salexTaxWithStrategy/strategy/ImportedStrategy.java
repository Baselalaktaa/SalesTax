package salexTaxWithStrategy.strategy;

import salexTaxWithStrategy.Product;

/**
 * A strategy to tax products that are exempted and imported.
 * @author Basel Alaktaa
 * @since 02.09.2021 20:40
 */
public class ImportedStrategy implements TaxStrategy {
    @Override
    public float calculateTax(Product product) {
        return product.getPriceBeforeTax() * 0.05f;
    }
}
