package model;
/**
 * Class that represent order attributes
 */
public class Orders {
    private int id;
    private int quantity;
    private String productName;
    private String clientName;

    /**
     * Constructor with parameters
     * @param id order id
     * @param quantity order quantity
     * @param productName product name
     * @param clientName client name
     */
    public Orders(int id, int quantity, String productName, String clientName) {
        this.id = id;
        this.quantity = quantity;
        this.productName = productName;
        this.clientName = clientName;
    }

    /**
     * Constructor without parameters
     */
    public Orders() {
    }

    /**
     * Get order id
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Set order id
     * @param id id to be set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get order Quantity
     * @return int
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Get name of product ordered
     * @return String
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Get name of client who orders
     * @return String
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * Set quantity of order
     * @param quantity quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
