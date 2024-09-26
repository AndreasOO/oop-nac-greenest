public class PlantFactory {
    public PalmTree getPalmTree(String name, double height) {
        return new PalmTree(name,height);
    }

    public Carnivore getCarnivore(String name, double height) {
        return new Carnivore(name,height);
    }

    public Cactus getCactus(String name, double height) {
        return new Cactus(name,height);
    }
}
