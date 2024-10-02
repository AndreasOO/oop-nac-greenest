package Greenest.Hotel;

import Greenest.PlantCreation.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Cactus igge = PlantFactory.getStandardCactus("Igge", 0.20);
        PalmTree laura = PlantFactory.getStandardPalmTree("Laura", 5);
        Carnivore meatloaf = PlantFactory.getStandardCarnivore("Meatloaf", 0.7);
        PalmTree olof = PlantFactory.getStandardPalmTree("Olof", 1);
        PalmTree henry = PlantFactory.getThirstyPalmTree("Törstiga Henry", 1);
        Cactus kagge = PlantFactory.getThirstyCactus("Kagge", 0.5);
        Carnivore jonas = PlantFactory.getHungryCarnivore("Jonas", 12);



        List<Plant> plantsToCheckInToHotel = new ArrayList<>();
        plantsToCheckInToHotel.add(igge);
        plantsToCheckInToHotel.add(laura);
        plantsToCheckInToHotel.add(meatloaf);
        plantsToCheckInToHotel.add(olof);
        plantsToCheckInToHotel.add(henry);
        plantsToCheckInToHotel.add(kagge);
        plantsToCheckInToHotel.add(jonas);

        HotelOwner owner = new HotelOwner();
        owner.checkInPlantsToHotel(plantsToCheckInToHotel);
        owner.runProgram();


    }
}