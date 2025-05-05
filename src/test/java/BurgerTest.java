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

public class BurgerTest {

    @Mock
    Bun bunM;

    @Mock
    Ingredient ingredient1;

    @Mock
    Ingredient ingredient2;

    @Test
    public void runSetBunsTest() {
        Bun bun = new Bun("black bun", 100);
        Burger burger = new Burger();

        burger.setBuns(bun);

        assertEquals("Булка установлена некорректно", bun, burger.bun);
    }

    @Test
    public void runAddIngredientTest(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Burger burger = new Burger();

        burger.addIngredient(ingredient);

        assertEquals("В списке больше одного ингредиента", 1, burger.ingredients.size());
        assertEquals("В список добавился не тот ингредиент", ingredient, burger.ingredients.get(0));
    }

    @Test
    public void runRemoveIngredientTest(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Burger burger = new Burger();

        burger.addIngredient(ingredient);

        burger.removeIngredient(0);
        assertTrue("Ингредиент не убрался", burger.ingredients.isEmpty());
    }

    @Test
    public void runMoveIngredientTest(){
        Ingredient first = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Ingredient second = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        Burger burger = new Burger();

        burger.addIngredient(second);
        burger.addIngredient(first);

        burger.moveIngredient(0,1);

        assertEquals("Ингредиент стоит не там","hot sauce", burger.ingredients.get(0).getName());
        assertEquals("Ингредиент стоит не там","sour cream", burger.ingredients.get(1).getName());
    }

    @Test
    public void runGetPriceTest(){
        Burger burger = new Burger();

        when(bunM.getPrice()).thenReturn(50f);
        when(ingredient1.getPrice()).thenReturn(50f);
        when(ingredient2.getPrice()).thenReturn(50f);

        burger.setBuns(bunM);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        float expectedPrice = bunM.getPrice() * 2 + ingredient1.getPrice() + ingredient2.getPrice();
        assertEquals("Цена отличается", expectedPrice, burger.getPrice(), 0.001f);
    }

    @Test
    public void runGetReceiptTest(){
        Burger burger = new Burger();

        when(bunM.getPrice()).thenReturn(50f);
        when(bunM.getName()).thenReturn("Вкусна булка");

        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getPrice()).thenReturn(50f);
        when(ingredient1.getName()).thenReturn("Кепчук");

        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getPrice()).thenReturn(50f);
        when(ingredient2.getName()).thenReturn("Катлеточка");

        burger.setBuns(bunM);
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
