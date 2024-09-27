package Greenest.PlantCreation;

public class Carnivore extends Plant implements Nurtured, TableFormatable {
    private static final double BASE_LEVEL_NUTRITIONAL_VALUE = 0.1;
    private static final double ADDITIONAL_NUTRITIONAL_VALUE_PER_METER = 0.2;

    private final NutritionType nutritionType;
    private final PlantType plantType;

    protected Carnivore(String name, double heightInMeter) {
        super(name, heightInMeter);
        this.plantType = PlantType.CARNIVORE;
        this.nutritionType = NutritionType.PROTEIN_DRINK;
    }

    @Override
    public String getNutrientType() {
        return nutritionType.nutrient;
    }

    public String getPlantType() {
        return plantType.type;
    }

    @Override
    public double calculateDailyNutritionInLiter() {
        return BASE_LEVEL_NUTRITIONAL_VALUE + (ADDITIONAL_NUTRITIONAL_VALUE_PER_METER*this.getHeightInMeter());
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
