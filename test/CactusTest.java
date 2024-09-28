import Greenest.PlantCreation.Cactus;
import Greenest.PlantCreation.PalmTree;
import Greenest.PlantCreation.PlantFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertTrue;


//TODO: Add corner case test and high/low numbers.
//TODO: Add BDD flow
class CactusTest {

    Cactus cactus1 = PlantFactory.getCactus("Igge", 5);
    Cactus cactus2 = PlantFactory.getCactus("Sam", 25);
    Cactus cactus3 = PlantFactory.getCactus("Ford", 6);


    @Test
    void testNutrientType() {
        assertEquals("Mineral Water", cactus1.getNutrientType());
    }

    @Test
    void testPlantType() {
        assertEquals("Cactus", cactus1.getPlantType());
    }

    @Test
    void testCalculateDailyNutritionInLiter() {
        assertEquals(0.02, cactus1.calculateDailyNutritionInLiter());
        assertEquals(0.02, cactus2.calculateDailyNutritionInLiter());
        assertEquals(0.02, cactus3.calculateDailyNutritionInLiter());
    }

    @Test
    void testNutritionInstructions() {
        assertEquals("Cactus Igge should get 0.02 liter of Mineral Water per day", cactus1.createNutritionInstructions());
        assertEquals("Cactus Sam should get 0.02 liter of Mineral Water per day", cactus2.createNutritionInstructions());
        assertEquals("Cactus Ford should get 0.02 liter of Mineral Water per day", cactus3.createNutritionInstructions());
    }
}