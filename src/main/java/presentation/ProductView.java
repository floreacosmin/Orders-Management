package presentation;

import javax.swing.*;
import java.awt.*;
/**
 * UI Class for selecting the operation on Product table
 */

public class ProductView extends JFrame{
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel quantityLabel;
    private JLabel priceLabel;
    private JTextField idField;
    private JTextField nameField;
    private JTextField quantityField;
    private JTextField priceField;
    private JButton insertButton;
    private JButton deleteButton;
    private JButton findByIDButton;
    private JButton updateButton;
    private JButton findAllButton;
    private JButton exitButton;
    private JTextField message;

    /**
     * Constructor for ProductView
     */
    public ProductView(){
        idLabel = new JLabel("   id");
        nameLabel = new JLabel("   name");
        quantityLabel = new JLabel("   quantity");
        priceLabel = new JLabel("   price");
        idField = new JTextField();
        nameField = new JTextField();
        quantityField = new JTextField();
        priceField = new JTextField();

        insertButton = new JButton("INSERT");
        deleteButton = new JButton("DELETE");
        updateButton  = new JButton("UPDATE");
        findByIDButton = new JButton("FIND BY ID");
        findAllButton  = new JButton("FIND ALL");
        exitButton = new JButton("EXIT");

        message = new JTextField();

        this.setSize(600,350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Product operations");
        this.setBackground(Color.white);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        this.setContentPane(panel1);
        panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
        panel2.setLayout(new GridLayout(4,2));

        panel2.add(idLabel);
        panel2.add(idField);
        panel2.add(nameLabel);
        panel2.add(nameField);
        panel2.add(quantityLabel);
        panel2.add(quantityField);
        panel2.add(priceLabel);
        panel2.add(priceField);


        panel3.add(insertButton);
        panel3.add(updateButton);
        panel3.add(deleteButton);
        panel3.add(findByIDButton);
        panel3.add(findAllButton);
        panel3.add(exitButton);

        panel1.add(panel2);
        panel1.add(panel3);

        message.setEditable(false);
        panel1.add(message);

        this.setVisible(false);
    }

    /**
     * return message field
     * @return JTextField
     */

    public JTextField getMessage() {
        return message;
    }

    /**
     * return exit button
     * @return JButton
     */

    public JButton getExit() {
        return exitButton;
    }

    /**
     * Return idField
     * @return JTextField
     */
    public JTextField getIdField() {
        return idField;
    }
    /**
     * Return nameField
     * @return JTextField
     */
    public JTextField getNameField() {
        return nameField;
    }
    /**
     * Return quantityField
     * @return JTextField
     */
    public JTextField getQuantityField() {
        return quantityField;
    }
    /**
     * Return priceField
     * @return JTextField
     */
    public JTextField getPriceField() {
        return priceField;
    }
    /**
     * Return insert button
     * @return JButton
     */
    public JButton getInsert() {
        return insertButton;
    }
    /**
     * Return delete button
     * @return JButton
     */
    public JButton getDelete() {
        return deleteButton;
    }
    /**
     * Return findById button
     * @return JButton
     */
    public JButton getFindByID() {
        return findByIDButton;
    }
    /**
     * Return update button
     * @return JButton
     */
    public JButton getUpdate() {
        return updateButton;
    }
    /**
     * Return findAll button
     * @return JButton
     */
    public JButton getFindAll() {
        return findAllButton;
    }

}
