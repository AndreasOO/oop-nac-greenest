package Greenest.Watering;

import Greenest.PlantCreation.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Cactus igge = PlantFactory.getCactus("Igge", 0.20);
        PalmTree laura = PlantFactory.getPalmTree("Laura", 5);
        Carnivore meatloaf = PlantFactory.getCarnivore("Meatloaf", 0.7);
        PalmTree olof = PlantFactory.getPalmTree("Olof", 1);

        List<TableFormatable> plantsToAddToTable = new ArrayList<>();
        plantsToAddToTable.add(igge);
        plantsToAddToTable.add(laura);
        plantsToAddToTable.add(meatloaf);
        plantsToAddToTable.add(olof);

        List<Nurtured> plantsToGetNutrients = new ArrayList<>();
        plantsToGetNutrients.add(igge);
        plantsToGetNutrients.add(laura);
        plantsToGetNutrients.add(meatloaf);
        plantsToGetNutrients.add(olof);

        List<Plant> plants = new ArrayList<>();
        plants.add(igge);
        plants.add(laura);
        plants.add(meatloaf);
        plants.add(olof);

        Owner owner = new Owner();
        owner.setPlantsToLoadToTable(plantsToAddToTable);
        owner.runProgram();


    }
}