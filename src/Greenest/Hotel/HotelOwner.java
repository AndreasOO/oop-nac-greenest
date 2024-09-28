package Greenest.Hotel;

import Greenest.PlantCreation.*;
import Greenest.GUI.*;

import javax.swing.*;
import java.io.EOFException;
import java.lang.instrument.IllegalClassFormatException;
import java.util.List;

public class HotelOwner {
    private final GUIObject GUI;
    private List<Plant> plantsInHotel;
    private String inputPlantNameFromUser;
    private String plantNutritionInstructions;
    private Plant plantToNutriate;


    public HotelOwner() {
        this.GUI = new GUIObject();
    }

    public void runProgram() {
        GUI.init();
        setUpTable();
        addEventListeners();
    }

    private void setUpTable() {
        try {
            addPlantsInHotelToTable();
        } catch (NullPointerException | IllegalClassFormatException e) {
            handleIncorrectSetup(e);
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
            findPlantToNutriate();
            createOutputToUser();
        } catch (EOFException e) {
            return;
        } catch (IllegalArgumentException e) {
            handleIllegalArgumentException(e);
            return;
        } catch (IllegalClassFormatException e) {
            handleIncorrectSetup(e);
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

    private void findPlantToNutriate() throws IllegalArgumentException {
        for (Plant plant : plantsInHotel) {
            if (plant.getName().equalsIgnoreCase(inputPlantNameFromUser)) {
                plantToNutriate = plant;
                return;
            }
        }
        throw new IllegalArgumentException("Plant name does not match any registered plants");
    }

    private void createOutputToUser() throws IllegalClassFormatException {
        if (plantToNutriate instanceof Nurtured nurtured) {
            plantNutritionInstructions = nurtured.createNutritionInstructions();
        } else {
            throw new IllegalClassFormatException("Plant cannot create nutrition instructions");
        }
    }

    private void showOutputToUser() {
        JOptionPane.showMessageDialog(GUI.getFrame(), plantNutritionInstructions);
    }


    public void checkInPlantsToHotel(List<Plant> plantsToCheckInToHotel) {
        this.plantsInHotel = plantsToCheckInToHotel;
    }


    private void addPlantsInHotelToTable() throws IllegalClassFormatException {
        if (plantsInHotel == null) {
            throw new NullPointerException("There are no plants to add to table");
        }
        for (Plant plant : plantsInHotel) {
            if (plant instanceof TableFormatable plantToTable) {
                GUI.getTableModel().addRow(plantToTable.toTableArray());
            }
            else {
                throw new IllegalClassFormatException("Plant cannot be formatted to table");
            }
        }
    }

    private void handleIncorrectSetup(Exception e) {
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
