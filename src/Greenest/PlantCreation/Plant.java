package Greenest.PlantCreation;

public abstract class Plant {
    private String name;
    private double height;


    protected Plant(String name, double height) {
        this.name = name;
        this.height = height;
    }
}
