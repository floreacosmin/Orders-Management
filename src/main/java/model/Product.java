package model;
/**
 * Class that represent Product attributes
 */
public class Product {
    private int id;
    private String name;
    private int quantity;
    private int price;

    /**
     * Constructor with parameters
     * @param id Product id
     * @param name Product name
     * @param quantity Product quantity
     * @param price Product price
     */
    public Product(int id, String name, int quantity, int price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Constructor without parameters
     */
    public Product() {

    }

    /**
     * Get the name of a product
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of a product
     * @param name name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get product id
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id of a product
     * @param id id to be set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the quantity of a product
     * @return int
     */
    public int getQuantity() {
        return quantity;
    }

    /** Set the auantitiy of a product
     * @param quantity the quantity to be set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Get the price of a product
     * @return int
     */
    public int getPrice() {
        return price;
    }

    /**
     * Set the price of a product
     * @param price price to be set
     */
    public void setPrice(int price) {
        this.price = price;
    }
}
