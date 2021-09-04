package salexTaxWithStrategy.strategy;

import salexTaxWithStrategy.Product;

/**
 * functional interface represent the strategy to calculate the tax.
 * @author Basel Alaktaa
 * @since 02.09.2021 20:15
 * @version 1.0
 */
public interface TaxStrategy {
    float calculateTax(Product product);
}
