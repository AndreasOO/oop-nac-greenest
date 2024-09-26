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
