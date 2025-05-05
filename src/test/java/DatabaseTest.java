import praktikum.*;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class DatabaseTest {

    @Test
    public void testAvailableBuns() {
        Database database = new Database();
        List<Bun> buns = database.availableBuns();

        assertEquals(3, buns.size());
        assertEquals("black bun", buns.get(0).getName());
        assertEquals(100.0f, buns.get(0).getPrice(), 0.001f); // <-- fix
    }

    @Test
    public void testAvailableIngredients() {
        Database database = new Database();
        List<Ingredient> ingredients = database.availableIngredients();

        assertEquals(6, ingredients.size());
        assertEquals("hot sauce", ingredients.get(0).getName());
        assertEquals(100, ingredients.get(0).getPrice(), 0.001f);
    }

}
