package Greenest.PlantCreation;

public abstract class Plant {
    private String name;
    private double heightInMeter;


    protected Plant(String name, double heightInMeter) {
        this.name = name;
        this.heightInMeter = heightInMeter;
    }
}
