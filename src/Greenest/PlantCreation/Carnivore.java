package Greenest.PlantCreation;

public class Carnivore extends Plant implements Nurtured, TableFormatable {
    private static final double BASE_LEVEL_NUTRITIONAL_VALUE_IN_LITER = 0.1;
    private static final double ADDITIONAL_NUTRITIONAL_VALUE_IN_LITER_PER_METER = 0.2;
    private static final PlantType PLANT_TYPE =  PlantType.CARNIVORE;
    private static final NutritionType NUTRITION_TYPE = NutritionType.PROTEIN_DRINK;

    protected Carnivore(String name, double heightInMeter) {
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
        return BASE_LEVEL_NUTRITIONAL_VALUE_IN_LITER + (ADDITIONAL_NUTRITIONAL_VALUE_IN_LITER_PER_METER *this.getHeightInMeter());
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
