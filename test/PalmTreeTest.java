import Greenest.PlantCreation.PalmTree;
import Greenest.PlantCreation.PlantFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;



class PalmTreeTest {

    PalmTree palmTree = PlantFactory.getPalmTree("Olof", 3);


    @Test
    void getNutrientType() {
        assertEquals("Tap Water", palmTree.getNutrientType());
    }

    @Test
    void getPlantType() {
        assertEquals("Palm Tree", palmTree.getPlantType());
    }

    @Test
    void calculateDailyNutritionInLiter() {
        assertEquals(1.5, palmTree.calculateDailyNutritionInLiter());
    }

    @Test
    void testNutritionInstructions() {
        assertEquals("Palm Tree Olof should get 1.50 liter of Tap Water per day",
                palmTree.createNutritionInstructions());
    }
}