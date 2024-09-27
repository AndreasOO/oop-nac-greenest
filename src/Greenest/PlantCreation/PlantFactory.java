package Greenest.PlantCreation;


/**
 * Static factory class for creating extended plant instances.
 * Constructors in extended classes are protected and cannot be accesses through the Owner. The Owner has to use
 * the factory class to get instances.
 */
public class PlantFactory {
    public static PalmTree getPalmTree(String name, double height) {
        return new PalmTree(name,height);
    }

    public static Carnivore getCarnivore(String name, double height) {
        return new Carnivore(name,height);
    }

    public static Cactus getCactus(String name, double height) {
        return new Cactus(name,height);
    }
}
