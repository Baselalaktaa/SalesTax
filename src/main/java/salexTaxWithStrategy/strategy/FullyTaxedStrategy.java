package salexTaxWithStrategy.strategy;

import salexTaxWithStrategy.Product;

public class FullyTaxedStrategy implements TaxStrategy {
    @Override
    public float taxProduct(Product product) {
        return product.getPrice() * .1f;
    }
}
