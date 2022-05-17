package presentation;

import bll.ClientBLL;
import bll.OrderBLL;
import bll.ProductBLL;
import model.Client;
import model.Orders;
import model.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that controll the UI Classes and implements ActionListener interface
 */

public class Controller implements ActionListener {

    private View view;
    private ClientView clientView;
    private ProductView productView;
    private OrderView orderView;
    private ClientBLL clientBLL;
    private ProductBLL productBLL;
    private OrderBLL orderBLL;
    private TableView<Client> table1;
    private TableView<Product> table2;
    private TableView<Orders> table3;

    public Controller() {
        this.view = new View();
        clientView = new ClientView();
        productView = new ProductView();
        orderView = new OrderView();
        clientBLL = new ClientBLL();
        productBLL = new ProductBLL();
        orderBLL = new OrderBLL();

        view.getProductOp().addActionListener(this);
        view.getClientOp().addActionListener(this);
        view.getCreateOrder().addActionListener(this);

        clientView.getExitButton().addActionListener(this);
        clientView.getInsertButton().addActionListener(this);
        clientView.getDeleteButton().addActionListener(this);
        clientView.getUpdateButton().addActionListener(this);
        clientView.getFindAllButton().addActionListener(this);
        clientView.getFindByIDButton().addActionListener(this);


        productView.getExit().addActionListener(this);
        productView.getInsert().addActionListener(this);
        productView.getDelete().addActionListener(this);
        productView.getUpdate().addActionListener(this);
        productView.getFindAll().addActionListener(this);
        productView.getFindByID().addActionListener(this);


        orderView.getInsertButton().addActionListener(this);
        orderView.getFindAll().addActionListener(this);
        orderView.getReloadButton().addActionListener(this);
        orderView.getExitButton().addActionListener(this);
    }

    /**
     * The actionPerformed method from the interface ActionListener
     *
     * @param actionEvent
     */
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == view.getClientOp()) {
            view.setVisible(false);
            clientView.setVisible(true);
        }

        if (actionEvent.getSource() == view.getProductOp()) {
            view.setVisible(false);
            productView.setVisible(true);
        }

        if (actionEvent.getSource() == productView.getExit()) {
            productView.setVisible(false);
            view.setVisible(true);
        }

        if (actionEvent.getSource() == clientView.getExitButton()) {
            clientView.setVisible(false);
            view.setVisible(true);
        }

        if (actionEvent.getSource() == orderView.getExitButton()) {
            orderView.setVisible(false);
            view.setVisible(true);
        }

        if (actionEvent.getSource() == view.getCreateOrder()) {
            view.setVisible(false);
            orderView.setVisible(true);
            List<Client> list1 = clientBLL.findAllClient();
            table1 = new TableView<>(list1);
            List<Product> list2 = productBLL.findAllProduct();
            table2 = new TableView<>(list2);
        }

        if (actionEvent.getSource() == clientView.getInsertButton()) {
            int id = 1;
            int age = Integer.parseInt(clientView.getAgeField().getText());
            String name = clientView.getNameField().getText();
            String address = clientView.getAdressField().getText();
            String email = clientView.getEmailField().getText();
            try {
                clientBLL.insertClient(new Client(id, name, address, email, age));
            } catch (IllegalArgumentException exception) {
                clientView.getMessage().setText(exception.getMessage());
            }
        }

        if (actionEvent.getSource() == clientView.getUpdateButton()) {
            int id = Integer.parseInt(clientView.getIdField().getText());
            int age = Integer.parseInt(clientView.getAgeField().getText());
            String name = clientView.getNameField().getText();
            String address = clientView.getAdressField().getText();
            String email = clientView.getEmailField().getText();

            try {
                clientBLL.updateClient(new Client(id, name, address, email, age));
            } catch (IllegalArgumentException exception) {
                this.clientView.getMessage().setText(exception.getMessage());
            }
        }

        if (actionEvent.getSource() == clientView.getDeleteButton()) {
            clientBLL.deleteClient(Integer.parseInt(clientView.getIdField().getText()));
        }


        if (actionEvent.getSource() == clientView.getFindByIDButton()) {
            int id = Integer.parseInt(clientView.getIdField().getText());
            ArrayList<Client> list = new ArrayList<>();
            list.add(clientBLL.findClientById(id));
            table1 = new TableView<>(list);

        }

        if (actionEvent.getSource() == clientView.getFindAllButton()) {
            List<Client> list = clientBLL.findAllClient();
            table1 = new TableView<>(list);
        }

        if (actionEvent.getSource() == productView.getInsert()) {
            int id = 1;
            int quantity = Integer.parseInt(productView.getQuantityField().getText());
            int price = Integer.parseInt(productView.getPriceField().getText());
            String name = productView.getNameField().getText();
            try {
                productBLL.insertProduct(new Product(id, name, quantity, price));
            } catch (IllegalArgumentException exception) {
                productView.getMessage().setText(exception.getMessage());
            }
        }

        if (actionEvent.getSource() == productView.getDelete()) {
            productBLL.deleteProduct(Integer.parseInt(productView.getIdField().getText()));
        }

        if (actionEvent.getSource() == productView.getUpdate()) {
            int id = Integer.parseInt(productView.getIdField().getText());
            int quantity = Integer.parseInt(productView.getQuantityField().getText());
            int price = Integer.parseInt(productView.getPriceField().getText());
            String name = productView.getNameField().getText();
            try {
                productBLL.updateProduct(new Product(id, name, quantity, price));
            } catch (IllegalArgumentException exception) {
                productView.getMessage().setText(exception.getMessage());
            }
        }

        if (actionEvent.getSource() == productView.getFindByID()) {
            int id = Integer.parseInt(productView.getIdField().getText());
            Product product = productBLL.findProductById(id);
            ArrayList<Product> list = new ArrayList<>();
            list.add(product);
            table2 = new TableView<>(list);

        }

        if (actionEvent.getSource() == productView.getFindAll()) {
            List<Product> list = productBLL.findAllProduct();
            table2 = new TableView<>(list);
        }
        //order
        if (actionEvent.getSource() == orderView.getFindAll()) {
            List<Orders> list = orderBLL.findAllOrder();
            table3 = new TableView<>(list);
        }

        if (actionEvent.getSource() == orderView.getInsertButton()) {
            int clientRow = table1.getTable().getSelectedRow();
            int productRow = table2.getTable().getSelectedRow();
            int quantity = Integer.parseInt(orderView.getQuantityField().getText());

            Product product = new Product();

            String clientName = table1.getTable().getModel().getValueAt(clientRow, 1).toString();

            product.setId(Integer.parseInt(table2.getTable().getModel().getValueAt(productRow, 0).toString()));
            product.setName(table2.getTable().getModel().getValueAt(productRow, 1).toString());
            product.setQuantity(Integer.parseInt(table2.getTable().getModel().getValueAt(productRow, 2).toString()));
            product.setPrice(Integer.parseInt(table2.getTable().getModel().getValueAt(productRow, 3).toString()));
            product.setQuantity(product.getQuantity() - quantity);

            try {
                productBLL.updateProduct(product);
                Orders order = new Orders(1, quantity, product.getName(), clientName);
                order.setId(orderBLL.insertOrder(order));
            } catch (IllegalArgumentException exception) {
                orderView.getMessage().setText(exception.getMessage());
            }

        }




        if (actionEvent.getSource() == orderView.getReloadButton()) {
            List<Product> list2 = productBLL.findAllProduct();
            table2.setVisible(false);
            table2 = new TableView<>(list2);
        }


    }
}
