package bll;


import bll.validators.*;
import dao.ProductDAO;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class for product operations
 */

public class ProductBLL {
    private List<Validator<Product>> validators;
    private ProductDAO productDAO;


    /**
     * Constructor without parameters
     */
    public ProductBLL() {
        validators = new ArrayList<Validator<Product>>();
        validators.add(new PriceValidator());
        validators.add(new QuantityValidator());

        productDAO = new ProductDAO();
    }

    /**
     * Method for searching a product by id
     * @param id search by id
     * @return Product
     */
    public Product findProductById(int id) {
        Product product = productDAO.findById(id);
        if (product == null) {
            throw new NoSuchElementException("The product with id =" + id + " was not found!");
        }
        return product;
    }

    /**
     * Method returns the list of products in the database
     * @return List<Product>
     */
    public List<Product> findAllProduct() {
        return productDAO.findAll();
    }

    /**
     * Method for validating and inserting a product
     * @param product Product to be inserted
     * @return int
     */
    public int insertProduct(Product product) {
        for (Validator<Product> v : validators) {
            v.validate(product);
        }
        return productDAO.insert(product);
    }

    /**
     * Method for validating and updating a product
     * @param product Product to be updated
     * @return int
     */
    public int updateProduct(Product product) {
        for (Validator<Product> v : validators) {
            v.validate(product);
        }
        return productDAO.update(product);
    }

    /**
     * Method for deleting a product with give id
     * @param id ID of product to be deleted
     * @return int
     */
    public int deleteProduct(int id) {
        int deletedId = productDAO.delete(id);
        if (deletedId == 0) {
            throw new NoSuchElementException("The Product with id =" + id + " was not found!");
        }
        return deletedId;
    }

}
