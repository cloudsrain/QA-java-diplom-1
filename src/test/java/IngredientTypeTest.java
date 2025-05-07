import org.junit.Test;
import static org.junit.Assert.*;
import praktikum.IngredientType;



public class IngredientTypeTest {

    @Test
    public void runShouldContainSauceTypeTest() {
        assertNotNull("Тип SAUCE не найден", IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void runShouldContainFillingTypeTest() {
        assertNotNull("Тип FILLING не найден", IngredientType.valueOf("FILLING"));
    }

    @Test
    public void runShouldReturnCorrectNumberOfValuesTest() {
        IngredientType[] values = IngredientType.values();
        assertEquals("Количество типов ингредиентов отличается", 2, values.length);
    }

}
