package bll.validators;

import model.Orders;
import model.Product;

/**
 * Class for validating order quantity
 */
public class OrderQuantityValidator implements Validator<Orders>{

    /**
     * Method for validating order quantity
     * @param order Order to validate
     */
    public void validate(Orders order) {
        if (order.getQuantity() < 0) {
            throw new IllegalArgumentException("Quantity is not a valid number!");
        }
    }
}
