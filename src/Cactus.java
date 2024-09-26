public class Cactus extends Plant implements Nurtured {
    private NutritionType nutritionType;
    private PlantType plantType;

    protected Cactus(String name, double height) {
        super(name, height);
    }

    @Override
    public String getNutrientType() {
        return "";
    }

    @Override
    public double calculateDailyNutritionInLiter() {
        return 0.0;
    }
}
