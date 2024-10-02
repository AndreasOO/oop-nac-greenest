import Greenest.PlantCreation.Carnivore;
import Greenest.PlantCreation.PlantFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;



class CarnivoreTest {

    Carnivore carnivore = PlantFactory.getStandardCarnivore("Meatloaf", 0.50);


    @Test
    void getNutrientType() {
        assertEquals("Protein Drink", carnivore.getNutrientType());
    }

    @Test
    void getPlantType() {
        assertEquals("Carnivore", carnivore.getPlantType());
    }

    @Test
    void calculateDailyNutritionInLiter() {
        assertEquals(0.2, carnivore.calculateDailyNutritionInLiter());
    }

    @Test
    void testNutritionInstructions() {
        assertEquals("Carnivore Meatloaf should get 0.20 liter of Protein Drink per day",
                                carnivore.createNutritionInstructions());
    }
}