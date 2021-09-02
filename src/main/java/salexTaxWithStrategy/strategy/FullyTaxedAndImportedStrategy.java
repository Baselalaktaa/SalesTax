package salexTaxWithStrategy.strategy;

import salexTaxWithStrategy.Product;

public class FullyTaxedAndImportedStrategy implements TaxStrategy {
    @Override
    public float taxProduct(Product product) {
        return product.getPrice() * .15f;
    }
}
