import Greenest.PlantCreation.Carnivore;
import Greenest.PlantCreation.PalmTree;
import Greenest.PlantCreation.PlantFactory;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertTrue;

//TODO: Add corner case test and high/low numbers.
//TODO: Add BDD flow
class CarnivoreTest {

    Carnivore carnivore = PlantFactory.getCarnivore("plant name", 0.50);


    @Test
    void getNutrientType() {
        assertTrue(carnivore.getNutrientType().equals("Protein Drink"));
    }

    @Test
    void calculateDailyNutritionInLiter() {
        assertTrue(carnivore.calculateDailyNutritionInLiter() == 0.2);
    }
}