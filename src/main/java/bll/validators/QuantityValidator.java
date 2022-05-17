package bll.validators;

import model.Product;

/**
 * Class for validating product quantity
 */
public class QuantityValidator implements Validator<Product>{

    /**
     * Method for validating product quantity
     * @param product Product to validate
     */
    public void validate(Product product) {
        if (product.getQuantity() < 0) {
            throw new IllegalArgumentException("Quantity is not a valid number!");
        }
    }
}
