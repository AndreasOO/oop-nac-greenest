package Greenest.PlantCreation;

public class Carnivore extends Plant implements Nurtured, TableFormatable {
    private double BASE_LEVEL_NUTRITIONAL_VALUE_IN_LITER = 0.1;
    private double ADDITIONAL_NUTRITIONAL_VALUE_IN_LITER_PER_METER = 0.2;
    private static final PlantType PLANT_TYPE =  PlantType.CARNIVORE;
    private NutritionType NUTRITION_TYPE = NutritionType.PROTEIN_DRINK;

    protected Carnivore(String name, double heightInMeter) {
        super(name, heightInMeter);
    }

    public String getPlantType() {
        return PLANT_TYPE.type;
    }


    protected void setBASE_LEVEL_NUTRITIONAL_VALUE_IN_LITER(double BASE_LEVEL_NUTRITIONAL_VALUE_IN_LITER) {
        this.BASE_LEVEL_NUTRITIONAL_VALUE_IN_LITER = BASE_LEVEL_NUTRITIONAL_VALUE_IN_LITER;
    }

    protected void setADDITIONAL_NUTRITIONAL_VALUE_IN_LITER_PER_METER(double ADDITIONAL_NUTRITIONAL_VALUE_IN_LITER_PER_METER) {
        this.ADDITIONAL_NUTRITIONAL_VALUE_IN_LITER_PER_METER = ADDITIONAL_NUTRITIONAL_VALUE_IN_LITER_PER_METER;
    }

    protected void setNUTRITION_TYPE(NutritionType NUTRITION_TYPE) {
        this.NUTRITION_TYPE = NUTRITION_TYPE;
    }

    @Override
    public String getNutrientType() {
        return NUTRITION_TYPE.nutrient;
    }

    // Implemented interface method to calculate nutrition in liter units. This method is required by the other
    // interface method that creates nutrition instructions.
    @Override
    public double calculateDailyNutritionInLiter() {
        return BASE_LEVEL_NUTRITIONAL_VALUE_IN_LITER + (ADDITIONAL_NUTRITIONAL_VALUE_IN_LITER_PER_METER *this.getHeightInMeter());
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
