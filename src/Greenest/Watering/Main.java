package Greenest.Watering;

import Greenest.PlantCreation.*;

public class Main {
    public static void main(String[] args) {
        Owner owner = new Owner();
        PalmTree palmTree = PlantFactory.getPalmTree("test", 2.0);
        Cactus cactus = PlantFactory.getCactus("test2", 3.0);


    }
}