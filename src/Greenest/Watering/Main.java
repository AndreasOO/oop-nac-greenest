package Greenest.Watering;

import Greenest.PlantCreation.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Owner owner = new Owner();

        Cactus igge = PlantFactory.getCactus("Igge", 0.20);
        PalmTree laura = PlantFactory.getPalmTree("Laura", 5);
        Carnivore meatloaf = PlantFactory.getCarnivore("Meatloaf", 0.7);
        PalmTree olof = PlantFactory.getPalmTree("Olof", 1);

        List<TableFormatable> plantsToAddToTable = new ArrayList<>();
        plantsToAddToTable.add(igge);
        plantsToAddToTable.add(laura);
        plantsToAddToTable.add(meatloaf);
        plantsToAddToTable.add(olof);


        owner.setPlantLoad(plantsToAddToTable);

        owner.runProgram();


    }
}