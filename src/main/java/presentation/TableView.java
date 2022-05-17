package presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * UI Class for displaying the result of find operations in a JTable
 */

public class TableView<T> extends JFrame {
    private JTable table;
    private JScrollPane scrollPanel;

    /**
     * Return the table
     * @return JTable
     */
    public JTable getTable() {
        return table;
    }

    /**
     * Constructor for TableView
     * @param list List of generic objects
     */
    public TableView(List<T> list) {
        this.table = this.createTable(list);
        this.setSize(700, 700);
        this.scrollPanel = new JScrollPane(this.table);
        this.add(scrollPanel);
        this.setVisible(true);

    }

    /**
     * Create a table from a list of genetic objects
     * @param list list of objects that will be displayed in the table
     * @return JTable
     */
    public JTable createTable(List<T> list) {
        ArrayList<String> columnNames = new ArrayList<>();
        int numberOfFields = 0;
        for (Field field : list.get(0).getClass().getDeclaredFields()) {
            field.setAccessible(true);
            columnNames.add(field.getName());
            numberOfFields++;
        }
        Object[][] obj = new Object[list.size()][numberOfFields];
        int j;
        for (int i = 0; i < list.size(); i++) {
            j = 0;
            for (Field field : list.get(i).getClass().getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    obj[i][j] = field.get(list.get(i));
                    j++;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        DefaultTableModel tModel = new DefaultTableModel(obj, columnNames.toArray());
        JTable table = new JTable(tModel);
        return table;
    }
}
