import praktikum.Ingredient;
import praktikum.IngredientType;

import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    private IngredientType actualType;
    private String actualName;
    private float actualPrice;


    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name ="Тест {index}: {0}, {1}, {2}")
    public static Object[][] getOrder() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300},

        };
    }

    @Before
    public void ingredientCreation(){
        Ingredient ingredient = new Ingredient(type,name,price);
        actualType = ingredient.getType();
        actualName = ingredient.getName();
        actualPrice = ingredient.getPrice();
    }

    @Test
    public void runGetIngredientTypeTest(){
        assertEquals("Ожидался другой тип", type, actualType);
        assertEquals("Ожидался другое название", name, actualName);
        assertEquals("Ожидалась другая цена", price, actualPrice, 0.001f);
    }

}
