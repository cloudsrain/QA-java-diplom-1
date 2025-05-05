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

}
