package presentation;

import javax.swing.*;
import java.awt.*;

/**
 * The main UI class
 * Used to select the UI for the table on which the queries will be executed
 */

public class View extends JFrame {
    private final JLabel txtLabel;
    private final JButton clientOpButton;
    private final JButton productOpButton;
    private  final JButton createOrderButton;


    /**
     * Constructor for the main View
     */
    public View(){
        this.setSize(600,350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Main view");
        this.setBackground(Color.white);
        txtLabel = new JLabel("Select operation");
        txtLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        clientOpButton = new JButton("Client operations");
        productOpButton = new JButton("Product operations");
        createOrderButton = new JButton("Create order");

        this.setLayout(null);

        this.add(txtLabel);
        this.add(clientOpButton);
        this.add(productOpButton);
        this.add(createOrderButton);

        txtLabel.setBounds(220, 20,200,40);
        clientOpButton.setBounds(200,100,200,40);
        productOpButton.setBounds(200,160,200,40);
        createOrderButton.setBounds(200,220,200,40);
        this.setVisible(true);
    }

    /**
     * Return clientOp button
     * @return JButton
     */
    public JButton getClientOp() {
        return clientOpButton;
    }

    /**
     * Return productOp button
     * @return JButton
     */
    public JButton getProductOp() {
        return productOpButton;
    }

    /**
     * Return orderOp button
     * @return JButton
     */
    public JButton getCreateOrder() {
        return createOrderButton;
    }

}