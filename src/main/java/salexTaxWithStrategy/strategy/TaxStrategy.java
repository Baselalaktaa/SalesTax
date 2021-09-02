package salexTaxWithStrategy.strategy;

import salexTaxWithStrategy.Product;

public interface TaxStrategy {
    float taxProduct(Product product);
}
