import Greenest.PlantCreation.PalmTree;
import Greenest.PlantCreation.PlantFactory;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertTrue;

//TODO: Add corner case test and high/low numbers.
//TODO: Add BDD flow
class PalmTreeTest {

    PalmTree palmTree = PlantFactory.getPalmTree("plant name", 3);


    @Test
    void getNutrientType() {
        assertTrue(palmTree.getNutrientType().equals("Tap Water"));
    }

    @Test
    void getPlantType() {
        assertTrue(palmTree.getPlantType().type.equals("Palm Tree"));
    }

    @Test
    void calculateDailyNutritionInLiter() {
        assertTrue(palmTree.calculateDailyNutritionInLiter() == 1.5);
    }
}