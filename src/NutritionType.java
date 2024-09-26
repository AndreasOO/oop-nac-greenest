public enum NutritionType {
    WATER("Water"),
    MINERAL_WATER("Mineral Water"),
    PROTEIN_DRINK("Protein Drink");

    public final String nutrient;

    NutritionType(String nutrient) {
        this.nutrient = nutrient;
    }
}
