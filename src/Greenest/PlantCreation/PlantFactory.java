package Greenest.PlantCreation;


/**
 * Static factory class for creating extended plant instances.
 * Constructors in extended classes are protected and cannot be accessed outside package. Classes outside this package
 * have to use the factory class static methods to get instances.
 */
public class PlantFactory {
    public static PalmTree getStandardPalmTree(String name, double heightInMeter) {
        return new PalmTree(name,heightInMeter);
    }

    public static PalmTree getThirstyPalmTree(String name, double heightInMeter) {
        PalmTree palmTree = new PalmTree(name,heightInMeter);
        palmTree.setNUTRITION_COEFFICIENT_IN_LITER_PER_METER(3.5);
        return palmTree;
    }

    public static Carnivore getStandardCarnivore(String name, double heightInMeter) {
        return new Carnivore(name,heightInMeter);
    }

    public static Carnivore getHungryCarnivore(String name, double heightInMeter) {
       Carnivore carnivore = new Carnivore(name,heightInMeter);
       carnivore.setBASE_LEVEL_NUTRITIONAL_VALUE_IN_LITER(2);
       carnivore.setADDITIONAL_NUTRITIONAL_VALUE_IN_LITER_PER_METER(1.2);
       return carnivore;
    }

    public static Cactus getStandardCactus(String name, double heightInMeter) {
        return new Cactus(name,heightInMeter);
    }

    public static Cactus getThirstyCactus(String name, double heightInMeter) {
        Cactus cactus = new Cactus(name,heightInMeter);
        cactus.setDAILY_NUTRITIONAL_VALUE_IN_LITER(1.2);
        return cactus;
    }
}
