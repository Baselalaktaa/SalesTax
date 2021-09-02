package salexTaxWithStrategy.strategy;

import salexTaxWithStrategy.Product;

public class NotTaxedStrategy implements TaxStrategy {
    @Override
    public float taxProduct(Product product) {
        return 0.00f;
    }
}
