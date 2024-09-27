package Greenest.PlantCreation;

public enum PlantType {
    PALM_TREE("Palm Tree"),
    CARNIVORE("Carnivore"),
    CACTUS("Cactus");

    public final String type;

    PlantType(String type) {
        this.type = type;
    }
}
