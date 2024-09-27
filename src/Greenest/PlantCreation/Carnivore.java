package Greenest.PlantCreation;

public class Carnivore extends Plant implements Nurtured {
    private static final double BASE_LEVEL_NUTRITIONAL_VALUE = 0.1;
    private static final double ADDITIONAL_NUTRITIONAL_VALUE_PER_METER = 0.2;

    private NutritionType nutritionType;
    private PlantType plantType;

    protected Carnivore(String name, double heightInMeter) {
        super(name, heightInMeter);
        this.plantType = PlantType.CARNIVORE;
        this.nutritionType = NutritionType.PROTEIN_DRINK;
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
        return BASE_LEVEL_NUTRITIONAL_VALUE + (ADDITIONAL_NUTRITIONAL_VALUE_PER_METER*this.getHeightInMeter());
    }
}
