package salexTaxWithStrategy.strategy;

import salexTaxWithStrategy.Product;

public class ImportedStrategy implements TaxStrategy {
    @Override
    public float taxProduct(Product product) {
        return product.getPrice() * 0.05f;
    }
}
