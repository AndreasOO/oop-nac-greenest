package Greenest.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class GUIObject {
    private final String[] COLUMN_NAMES = {"Plant Name", "Plant Type", "Height in meters", "Nutrition Type"};
    private final JFrame FRAME;
    private final JPanel PANEL;

    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private JButton openDialogButton;

    public GUIObject() {
        FRAME = new JFrame();
        PANEL = new JPanel();
    }

    public void init() {
        setupTable();
        setupDialogButton();
        setupPanel();
        setupFrame();
        initializeAndShowFrame();
    }

    private void setupTable() {
        JTable caseTable = new JTable(new DefaultTableModel(COLUMN_NAMES, 0));
        caseTable.setBounds(0, 0, 1000, 600);
        tableModel = (DefaultTableModel) caseTable.getModel();
        scrollPane = new JScrollPane(caseTable);
    }

    private void setupDialogButton() {
        openDialogButton = new JButton("Water plant");
        openDialogButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
    }

    private void setupPanel() {
        PANEL.setLayout(new BorderLayout());
        PANEL.add(scrollPane, BorderLayout.CENTER);
        PANEL.add(openDialogButton, BorderLayout.SOUTH);
    }

    private void setupFrame() {
        FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FRAME.setTitle("Greenest");
        FRAME.setSize(1000, 800);
        FRAME.setLocationRelativeTo(null);
    }

    private void initializeAndShowFrame() {
        FRAME.getContentPane().add(PANEL);
        FRAME.setVisible(true);
    }

    public JFrame getFrame() {
        return FRAME;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public JButton getOpenDialogButton() {
        return openDialogButton;
    }

}


