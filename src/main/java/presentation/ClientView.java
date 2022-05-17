package presentation;

import javax.swing.*;


import java.awt.*;

/**
 * UI Class for selecting the operation on Client table
 */

public class ClientView extends JFrame {
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel emailLabel;
    private JLabel ageLabel;
    private JLabel adressLabel;
    private JTextField idField;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField ageField;
    private JTextField adressField;
    private JButton insertButton;
    private JButton deleteButton;
    private JButton findByIDButton;
    private JButton updateButton;
    private JButton findAllButton;
    private JButton exitButton;
    private JTextField message;


    /**
     * Constructor for ClientView
     */
    public ClientView() {
        idLabel = new JLabel("   ID");
        nameLabel = new JLabel("   name");
        emailLabel = new JLabel("   email");
        ageLabel = new JLabel("   age");
        adressLabel = new JLabel("   adress");
        idField = new JTextField();
        nameField = new JTextField();
        emailField = new JTextField();
        ageField = new JTextField();
        adressField = new JTextField();
        insertButton = new JButton("INSERT");
        deleteButton = new JButton("DELETE");
        updateButton = new JButton("UPDATE");
        findByIDButton = new JButton("FIND BY ID");
        findAllButton = new JButton("FIND ALL");
        exitButton = new JButton("EXIT");
        message = new JTextField();

        this.setSize(600, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Client operations");
        this.setBackground(Color.white);
        JPanel panel1 = new JPanel();
        this.setContentPane(panel1);
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(5, 2));
        panel2.add(idLabel);
        panel2.add(idField);
        panel2.add(nameLabel);
        panel2.add(nameField);
        panel2.add(adressLabel);
        panel2.add(adressField);
        panel2.add(emailLabel);
        panel2.add(emailField);
        panel2.add(ageLabel);
        panel2.add(ageField);


        JPanel panel3 = new JPanel();
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
     * Return emailField
     * @return JTextField
     */
    public JTextField getEmailField() {
        return emailField;
    }
    /**
     * Return AgeField
     * @return JTextField
     */
    public JTextField getAgeField() {
        return ageField;
    }
    /**
     * Return adressField
     * @return JTextField
     */
    public JTextField getAdressField() {
        return adressField;
    }
    /**
     * Return insert button
     * @return JButton
     */
    public JButton getInsertButton() {
        return insertButton;
    }
    /**
     * Return delete button
     * @return JButton
     */
    public JButton getDeleteButton() {
        return deleteButton;
    }
    /**
     * Return findByID button
     * @return JButton
     */
    public JButton getFindByIDButton() {
        return findByIDButton;
    }
    /**
     * Return update button
     * @return JButton
     */
    public JButton getUpdateButton() {
        return updateButton;
    }
    /**
     * Return findAll button
     * @return JButton
     */
    public JButton getFindAllButton() {
        return findAllButton;
    }
    /**
     * Return findAll button
     * @return JButton
     */
    public JButton getExitButton() {
        return exitButton;
    }

    /**
     * Return message field
     * @return JTextField
     */
    public JTextField getMessage() {
        return message;
    }
}
