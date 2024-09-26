import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PalmTreeTest {

    PalmTree palmTree = PlantFactory.getPalmTree("plant name", 2.5);

    @Test
    void getNutrientType() {
        assert(palmTree.getNutrientType().equals("Palm Tree"));
    }

    @Test
    void calculateDailyNutritionInLiter() {
        assert(palmTree.calculateDailyNutritionInLiter() == 14.4);
    }
}