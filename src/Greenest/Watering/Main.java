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


        List<Plant> plantsInGarden = new ArrayList<>();
        plantsInGarden.add(igge);
        plantsInGarden.add(laura);
        plantsInGarden.add(meatloaf);
        plantsInGarden.add(olof);

        Owner owner = new Owner();
        owner.setPlantsInGarden(plantsInGarden);
        owner.runProgram();


    }
}