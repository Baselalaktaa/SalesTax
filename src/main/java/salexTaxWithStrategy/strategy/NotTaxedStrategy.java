package salexTaxWithStrategy.strategy;

import salexTaxWithStrategy.Product;

/**
 * A strategy to tax products that are exempted and not imported.
 * @author Basel Alaktaa
 * @since 02.09.2021 20:40
 */

public class NotTaxedStrategy implements TaxStrategy {
    @Override
    public float taxProduct(Product product) {
        return 0.00f;
    }
}
