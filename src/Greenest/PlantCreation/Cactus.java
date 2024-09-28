package Greenest.PlantCreation;

public class Cactus extends Plant implements Nurtured, TableFormatable {
    private static final double DAILY_NUTRITIONAL_VALUE_IN_LITER = 0.02;
    private static final PlantType plantType =  PlantType.CACTUS;
    private static final NutritionType nutritionType = NutritionType.MINERAL_WATER;

    protected Cactus(String name, double heightInMeter) {
        super(name, heightInMeter);
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
        return DAILY_NUTRITIONAL_VALUE_IN_LITER;
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
