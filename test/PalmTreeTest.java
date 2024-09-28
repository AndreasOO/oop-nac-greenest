import Greenest.PlantCreation.PalmTree;
import Greenest.PlantCreation.PlantFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

//TODO: Add corner case test and high/low numbers.
//TODO: Add BDD flow
class PalmTreeTest {

    PalmTree palmTree = PlantFactory.getPalmTree("plant name", 3);


    @Test
    void getNutrientType() {
        Assertions.assertEquals("Tap Water", palmTree.getNutrientType());
    }

    @Test
    void getPlantType() {
        Assertions.assertEquals("Palm Tree", palmTree.getPlantType());
    }

    @Test
    void calculateDailyNutritionInLiter() {
        Assertions.assertEquals(1.5, palmTree.calculateDailyNutritionInLiter());
    }
}