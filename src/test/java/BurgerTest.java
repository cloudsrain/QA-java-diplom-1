import org.junit.Before;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;
import praktikum.Burger;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient1;

    @Mock
    Ingredient ingredient2;

    @Before
    public void setUp(){
        burger = new Burger();

        // Настройка булки
        when(bun.getName()).thenReturn("Вкусна булка");
        when(bun.getPrice()).thenReturn(50f);

        // Настройка ингредиента 1
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getName()).thenReturn("Кепчук");
        when(ingredient1.getPrice()).thenReturn(50f);

        // Настройка ингредиента 2
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getName()).thenReturn("Катлеточка");
        when(ingredient2.getPrice()).thenReturn(50f);
    }

    @Test
    public void runSetBunsTest() {
        burger.setBuns(bun);
        assertEquals("Булка установлена некорректно", bun, burger.bun);
    }

    @Test
    public void runAddIngredientTest(){
        burger.addIngredient(ingredient1);

        assertEquals("Ожидалось ровно 1 ингредиент", 1, burger.ingredients.size());
    }

    @Test
    public void runRemoveIngredientTest(){
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);

        assertTrue("Ингредиент не был удалён", burger.ingredients.isEmpty());
    }

    @Test
    public void runMoveIngredientTest(){
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient1);
        burger.moveIngredient(0, 1);

        assertEquals("Ингредиенты стоят в неправильном порядке", ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void runGetPriceTest(){
        burger = new Burger();

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        float expectedPrice = bun.getPrice() * 2 + ingredient1.getPrice() + ingredient2.getPrice();
        assertEquals("Цена отличается", expectedPrice, burger.getPrice(), 0.001f);
    }

    @Test
    public void runGetReceiptTest(){
        burger = new Burger();

        burger.setBuns(bun);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient1);

        String expected = String.format(
                "(==== %s ====)%n" +
                        "= %s %s =%n" +
                        "= %s %s =%n" +
                        "(==== %s ====)%n" +
                        "%nPrice: %f%n",
                "Вкусна булка",
                "filling", "Катлеточка",
                "sauce", "Кепчук",
                "Вкусна булка",
                200.0f
        );

        String actual = burger.getReceipt();

        assertEquals("Рецепт не совпал", expected, actual);
    }

}
