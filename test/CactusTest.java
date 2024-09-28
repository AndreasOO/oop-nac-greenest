import Greenest.PlantCreation.Cactus;
import Greenest.PlantCreation.PalmTree;
import Greenest.PlantCreation.PlantFactory;
import org.junit.jupiter.api.Assertions;
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
        Assertions.assertEquals("Mineral Water", cactus1.getNutrientType());
    }

    @Test
    void getPlantType() {
        Assertions.assertEquals("Cactus", cactus1.getPlantType());
    }

    @Test
    void calculateDailyNutritionInLiter() {
        Assertions.assertEquals(0.02, cactus1.calculateDailyNutritionInLiter());
        Assertions.assertEquals(0.02, cactus2.calculateDailyNutritionInLiter());
        Assertions.assertEquals(0.02, cactus3.calculateDailyNutritionInLiter());
    }
}