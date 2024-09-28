package Greenest.PlantCreation;

public abstract class Plant {
    private final String name;
    private final double heightInMeter;


    protected Plant(String name, double heightInMeter) {
        this.name = name;
        this.heightInMeter = heightInMeter;
    }

    public String getName() {
        return name;
    }

    public double getHeightInMeter() {
        return heightInMeter;
    }

}
