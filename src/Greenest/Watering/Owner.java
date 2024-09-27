package Greenest.Watering;

import javax.swing.*;
import Greenest.PlantCreation.*;
import Greenest.GUI.*;

import java.io.EOFException;
import java.util.List;

public class Owner {
    private final GUIObject GUI;
    private List<TableFormatable> plantsToLoadToTable;
    private final String promptForGettingPlantNameFromUser = "Which plant should get nutrients?";
    private String inputPlantNameFromUser;
    private String plantWateringInstructions;


    public Owner() {
        this.GUI = new GUIObject();
    }

    public void runProgram() {
        GUI.init();
        addPlantLoadToTable(plantsToLoadToTable);
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
        try {
            getInputFromUser();
            validateInputFromUser();
        } catch (EOFException e) {
            return;
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(GUI.getFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        createOutputToUser();
        outputToUser();
    }

    private void getInputFromUser() throws EOFException {
        inputPlantNameFromUser = JOptionPane.showInputDialog(GUI.getFrame(),
                                                             promptForGettingPlantNameFromUser,
                                                        "Input plant name",
                                                             JOptionPane.QUESTION_MESSAGE);
        if (inputPlantNameFromUser == null) {
            throw new EOFException();
        }
    }

    private void validateInputFromUser() throws EOFException {
        if (inputPlantNameFromUser == null) {
            throw new EOFException();
        }
        if (inputPlantNameFromUser.isEmpty()) {
            throw new IllegalArgumentException("Please input a plan name");
        }
        if (plantNameNotFound()) {
            throw new IllegalArgumentException("Plant name does not match any registered plants");
        }
    }

    private boolean plantNameNotFound() {
        for (TableFormatable plant : plantsToLoadToTable) {
            if (plant.toTableArray()[0].equalsIgnoreCase(inputPlantNameFromUser)) {
                return false;
            }
        }
        return true;
    }

    private void createOutputToUser() {
        for (TableFormatable plant : plantsToLoadToTable) {
            if (plant.toTableArray()[0].equalsIgnoreCase(inputPlantNameFromUser)) {
                Nurtured plant2 = (Nurtured) plant;
                plantWateringInstructions = plant2.createNutritionInstructions();
            }
        }
    }

    private void outputToUser() {
        JOptionPane.showMessageDialog(GUI.getFrame(), plantWateringInstructions);
    }


    public void setPlantsToLoadToTable(List<TableFormatable> plantsToLoad) {
        this.plantsToLoadToTable = plantsToLoad;
    }


    private void addPlantLoadToTable(List<TableFormatable> plantsToLoad) {
        for (TableFormatable plant : plantsToLoad) {
            GUI.getTableModel().addRow(plant.toTableArray());
        }
    }
}
