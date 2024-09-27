import Greenest.PlantCreation.Cactus;
import Greenest.PlantCreation.PalmTree;
import Greenest.PlantCreation.PlantFactory;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertTrue;


//TODO: Add corner case test and high/low numbers.
//TODO: Add BDD flow
class CactusTest {

    Cactus cactus1 = PlantFactory.getCactus("plant name", 5);
    Cactus cactus2 = PlantFactory.getCactus("plant name", 25);
    Cactus cactus3 = PlantFactory.getCactus("plant name", 6);


    @Test
    void getNutrientType() {
        assertTrue(cactus1.getNutrientType().equals("Mineral Water"));
    }

    @Test
    void getPlantType() {
        assertTrue(cactus1.getPlantType().type.equals("Cactus"));
    }

    @Test
    void calculateDailyNutritionInLiter() {
        assertTrue(cactus1.calculateDailyNutritionInLiter() == 0.02);
        assertTrue(cactus2.calculateDailyNutritionInLiter() == 0.02);
        assertTrue(cactus3.calculateDailyNutritionInLiter() == 0.02);
    }
}