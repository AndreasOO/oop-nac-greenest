package Greenest.PlantCreation;

public class Cactus extends Plant implements Nurtured {
    private static final double DAILY_NUTRITIONAL_VALUE_IN_LITER = 0.02;

    private NutritionType nutritionType;
    private PlantType plantType;

    protected Cactus(String name, double heightInMeter) {
        super(name, heightInMeter);
        this.plantType = PlantType.CACTUS;
        this.nutritionType = NutritionType.MINERAL_WATER;
    }

    @Override
    public String getNutrientType() {
        return nutritionType.nutrient;
    }


    public PlantType getPlantType() {
        return plantType;
    }

    @Override
    public double calculateDailyNutritionInLiter() {
        return DAILY_NUTRITIONAL_VALUE_IN_LITER;
    }
}
