package Greenest.PlantCreation;

public class PalmTree extends Plant implements Nurtured, TableFormatable {
    private static final double NUTRITION_COEFFICIENT_IN_LITER_PER_METER = 0.5;
    private static final PlantType PLANT_TYPE =  PlantType.PALM_TREE;
    private static final NutritionType NUTRITION_TYPE = NutritionType.TAP_WATER;

    protected PalmTree(String name, double heightInMeter) {
        super(name, heightInMeter);
    }

    public String getPlantType() {
        return PLANT_TYPE.type;
    }

    @Override
    public String getNutrientType() {
        return NUTRITION_TYPE.nutrient;
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
