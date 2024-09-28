package Greenest.PlantCreation;

public class Cactus extends Plant implements Nurtured, TableFormatable {
    private static final double DAILY_NUTRITIONAL_VALUE_IN_LITER = 0.02;
    private static final PlantType PLANT_TYPE =  PlantType.CACTUS;
    private static final NutritionType NUTRITION_TYPE = NutritionType.MINERAL_WATER;

    protected Cactus(String name, double heightInMeter) {
        super(name, heightInMeter);
    }

    public String getPlantType() {
        return PLANT_TYPE.type;
    }


    @Override
    public String getNutrientType() {
        return NUTRITION_TYPE.nutrient;
    }


    // Implemented interface method to calculate nutrition in liter units. This method is required by the other
    // interface method that creates nutrition instructions.
    @Override
    public double calculateDailyNutritionInLiter() {
        return DAILY_NUTRITIONAL_VALUE_IN_LITER;
    }

    // Implemented interface method to create nutrition instructions. This method and interface is required by
    // the methods that print out nutrition instructions to the user, thus increasing type safety.
    @Override
    public String createNutritionInstructions() {
        return String.format(String.format("%s %s should get %.2f liter of %s per day",
                this.getPlantType(),
                this.getName(),
                this.calculateDailyNutritionInLiter(),
                this.getNutrientType()));
    }

    // Implemented interface method to create a string array. This method and interface is required by the method that
    // populates the table with checked in plants, increasing type safety.
    @Override
    public String[] toTableArray() {
        return new String[]{
                this.getName(),
                this.getPlantType(),
                String.valueOf(this.getHeightInMeter()),
                this.getNutrientType()};
    }
}
