package bll;

import bll.validators.OrderQuantityValidator;
import bll.validators.Validator;
import dao.OrderDAO;
import model.Orders;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class for orders operations
 */

public class OrderBLL {
    private List<Validator<Orders>> validators;
    private OrderDAO orderDAO;


    /**
     * Constructor without parameters
     */
    public OrderBLL() {
        validators = new ArrayList<Validator<Orders>>();
        validators.add(new OrderQuantityValidator());
        orderDAO = new OrderDAO();
    }

    /**
     *  Method returns the list of orders in the database
     * @return List<Orders>
     */

    public List<Orders> findAllOrder(){
        return orderDAO.findAll();
    }

    /**
     * Method for validate and insert an order
     * @param order order to be inserted
     * @return int
     */

    public int insertOrder(Orders order) {
        for (Validator<Orders> v : validators) {
            v.validate(order);
        }
        return orderDAO.insert(order);
    }

}
