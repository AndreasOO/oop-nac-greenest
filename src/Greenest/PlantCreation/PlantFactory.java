package Greenest.PlantCreation;


/**
 * Static factory class for creating extended plant instances.
 * Constructors in extended classes are protected and cannot be accessed outside package. Classes outside this package
 * have to use the factory class static methods to get instances.
 */
public class PlantFactory {
    public static PalmTree getPalmTree(String name, double heightInMeter) {
        return new PalmTree(name,heightInMeter);
    }

    public static Carnivore getCarnivore(String name, double heightInMeter) {
        return new Carnivore(name,heightInMeter);
    }

    public static Cactus getCactus(String name, double heightInMeter) {
        return new Cactus(name,heightInMeter);
    }
}
