package Greenest.PlantCreation;

public class PalmTree extends Plant implements Nurtured, TableFormatable {
    private static final double NUTRITION_COEFFICIENT_IN_LITER_PER_METER = 0.5;

    private final NutritionType nutritionType;
    private final PlantType plantType;

    protected PalmTree(String name, double heightInMeter) {
        super(name, heightInMeter);
        this.plantType = PlantType.PALM_TREE;
        this.nutritionType = NutritionType.TAP_WATER;

    }

    public String getPlantType() {
        return plantType.type;
    }

    @Override
    public String getNutrientType() {
        return nutritionType.nutrient;
    }

    @Override
    public double calculateDailyNutritionInLiter() {
        return NUTRITION_COEFFICIENT_IN_LITER_PER_METER*this.getHeightInMeter();
    }

    @Override
    public String createNutritionInstructions() {
        return String.format(String.format("%s %s should get %.2f liter of %s per day",
                this.getPlantType(),
                this.getName(),
                this.calculateDailyNutritionInLiter(),
                this.getNutrientType()));
    }

    @Override
    public String[] toTableArray() {
        return new String[]{
                this.getName(),
                this.getPlantType(),
                String.valueOf(this.getHeightInMeter()),
                this.getNutrientType()};
    }
}
