package Greenest.Watering;

import javax.swing.*;
import Greenest.PlantCreation.*;
import Greenest.GUI.*;

import java.io.EOFException;
import java.lang.instrument.IllegalClassFormatException;
import java.util.List;

public class Owner {
    private final GUIObject GUI;
    private List<Plant> plantsInGarden;
    private String inputPlantNameFromUser;
    private String plantWateringInstructions;
    private Plant plantToWater;


    public Owner() {
        this.GUI = new GUIObject();
    }

    public void runProgram() {
        GUI.init();
        setUpTable();
        addEventListeners();
    }

    private void setUpTable() {
        try {
            addPlantsInGardenToTable();
        } catch (IllegalClassFormatException e) {
            handleIllegalClassFormatException(e);
        }
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
            findPlant();
            createOutputToUser();
        } catch (EOFException e) {
            return;
        } catch (IllegalArgumentException e) {
            handleIllegalArgumentException(e);
            return;
        } catch (IllegalClassFormatException e) {
            handleIllegalClassFormatException(e);
        }
        showOutputToUser();
    }



    private void getInputFromUser() throws EOFException {
        String promptForGettingPlantNameFromUser = "Which plant should get nutrients?";
        String promptTitle = "Input plant name";

        inputPlantNameFromUser = JOptionPane.showInputDialog(GUI.getFrame(),
                                                             promptForGettingPlantNameFromUser,
                                                             promptTitle,
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
            throw new IllegalArgumentException("Please input a plant name");
        }
    }

    private void findPlant() throws IllegalArgumentException {
        for (Plant plant : plantsInGarden) {
            if (plant.getName().equalsIgnoreCase(inputPlantNameFromUser)) {
                plantToWater = plant;
                return;
            }
        }
        throw new IllegalArgumentException("Plant name does not match any registered plants");
    }

    private void createOutputToUser() throws IllegalClassFormatException{
        if (plantToWater instanceof Nurtured nurtured) {
            plantWateringInstructions = nurtured.createNutritionInstructions();
        } else {
            throw new IllegalClassFormatException("Plant cannot create nutrition instructions");
        }
    }

    private void showOutputToUser() {
        JOptionPane.showMessageDialog(GUI.getFrame(), plantWateringInstructions);
    }


    public void setPlantsInGarden(List<Plant> plantsInGarden) {
        this.plantsInGarden = plantsInGarden;
    }

    private void addPlantsInGardenToTable() throws IllegalClassFormatException {
        for (Plant plant : plantsInGarden) {
            if (plant instanceof TableFormatable plantToTable) {
                GUI.getTableModel().addRow(plantToTable.toTableArray());
            }
            else {
                throw new IllegalClassFormatException("Plant cannot be formatted to table");
            }
        }
    }

    private void handleIllegalClassFormatException(IllegalClassFormatException e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
        JOptionPane.showMessageDialog(GUI.getFrame(), "Error - Unexpected error, closing application",
                "Error", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }

    private void handleIllegalArgumentException(IllegalArgumentException e) {
        JOptionPane.showMessageDialog(GUI.getFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
