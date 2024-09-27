package Greenest.Watering;

import Greenest.PlantCreation.PalmTree;
import Greenest.PlantCreation.PlantFactory;

public class Main {
    public static void main(String[] args) {
        Owner owner = new Owner();
        PalmTree palmTree = PlantFactory.getPalmTree("test", 2.0);
    }
}