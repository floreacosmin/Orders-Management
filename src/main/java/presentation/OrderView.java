package presentation;

import javax.swing.*;
import java.awt.*;

/**
 * UI Class for selecting the operation on Orders table
 */

public class OrderView extends JFrame {
    private JLabel quantity;
    private JTextField quantityField;
    private JButton insertButton;
    private JButton findAllButton;
    private JButton exitButton;
    private JButton reloadButton;
    private JTextField message;

    /**
     * Constructor for OrderView
     */
    public OrderView() {
        quantity = new JLabel("QUANTITY");
        quantityField = new JTextField();
        insertButton = new JButton("INSERT");
        exitButton = new JButton("EXIT");
        reloadButton = new JButton("RELOAD");
        findAllButton = new JButton("FIND ALL");
        message = new JTextField();

        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Order create");

        getContentPane().setBounds(0, 0, 600, 600);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.setBounds(20, 20, 300, 50);
        panel.add(quantity);
        panel.add(quantityField);
        getContentPane().add(panel);

        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
        buttons.setBounds(30, 70, 600, 100);
        buttons.add(insertButton);
        buttons.add(findAllButton);
        buttons.add(reloadButton);
        buttons.add(exitButton);
        getContentPane().add(buttons);
        message.setBounds(0, 170, 600, 200);
        message.setEditable(false);
        getContentPane().add(message);
        this.setVisible(false);


    }

    /**
     * Return message field
     * @return JTextField
     */
    public JTextField getMessage() {
        return message;
    }

    /**
     * Return findAll button
     * @return JButton
     */
    public JButton getFindAll() {
        return findAllButton;
    }

    /**
     * Return exit button
     * @return JButton
     */
    public JButton getExitButton() {
        return exitButton;
    }

    /**
     * Return insert button
     * @return JButton
     */
    public JButton getInsertButton() {
        return insertButton;
    }

    /**
     * Return quantity field
     * @return JTextField
     */
    public JTextField getQuantityField() {
        return quantityField;
    }

    /**
     * Return reload button
     * @return JButton
     */
    public JButton getReloadButton() {
        return reloadButton;
    }

}
