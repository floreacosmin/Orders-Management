package bll.validators;

import model.Product;

/**
 * Class for validating product price
 */
public class PriceValidator implements Validator<Product> {

    /**
     * Method for validating product price
     * @param product Product to validate
     */
    public void validate(Product product){
        if(product.getPrice() < 0){
            throw new IllegalArgumentException("Price is not a valid number!");
        }
    }
}
