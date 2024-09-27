package Greenest.PlantCreation;

public class PalmTree extends Plant implements Nurtured, TableFormatable {
    private static final double NUTRITION_COEFFICIENT = 0.5;

    private NutritionType nutritionType;
    private PlantType plantType;

    protected PalmTree(String name, double heightInMeter) {
        super(name, heightInMeter);
        this.plantType = PlantType.PALM_TREE;
        this.nutritionType = NutritionType.TAP_WATER;

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
        return NUTRITION_COEFFICIENT*this.getHeightInMeter();
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
