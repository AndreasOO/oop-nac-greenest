package Greenest.Hotel;

import Greenest.PlantCreation.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Cactus igge = PlantFactory.getCactus("Igge", 0.20);
        PalmTree laura = PlantFactory.getPalmTree("Laura", 5);
        Carnivore meatloaf = PlantFactory.getCarnivore("Meatloaf", 0.7);
        PalmTree olof = PlantFactory.getPalmTree("Olof", 1);


        List<Plant> plantsToCheckInToHotel = new ArrayList<>();
        plantsToCheckInToHotel.add(igge);
        plantsToCheckInToHotel.add(laura);
        plantsToCheckInToHotel.add(meatloaf);
        plantsToCheckInToHotel.add(olof);

        HotelOwner owner = new HotelOwner();
        owner.checkInPlantsToHotel(plantsToCheckInToHotel);
        owner.runProgram();


    }
}