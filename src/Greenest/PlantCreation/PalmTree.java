package Greenest.PlantCreation;

public class PalmTree extends Plant implements Nurtured {
    private NutritionType nutritionType;
    private PlantType plantType;

    protected PalmTree(String name, double heightInMeter) {
        super(name, heightInMeter);

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
