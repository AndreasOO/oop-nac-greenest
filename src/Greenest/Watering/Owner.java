package Greenest.Watering;

import javax.swing.*;
import Greenest.PlantCreation.*;
import Greenest.GUI.*;
import javax.swing.*;
import java.util.List;

public class Owner {
    private List<TableFormatable> plantsToLoad;
    private final GUIObject GUI;

    public Owner() {
        this.GUI = new GUIObject();
    }

    public void runProgram() {
        GUI.init();
        addPlantLoadToTable(plantsToLoad);
        addEventListeners();
    }

    private void addEventListeners() {
        GUI.getOpenDialogButton().addActionListener(e -> {
            if (e.getSource() == GUI.getOpenDialogButton()) {
                handleUserDialog();
            }
        });
    }

    private void handleUserDialog() {

    }

    public void setPlantLoad(List<TableFormatable> plantsToLoad) {
        this.plantsToLoad = plantsToLoad;
    }

    private void addPlantLoadToTable(List<TableFormatable> plantsToLoad) {
        for (TableFormatable plant : plantsToLoad) {
            GUI.getTableModel().addRow(plant.toTableArray());
        }
    }
}
