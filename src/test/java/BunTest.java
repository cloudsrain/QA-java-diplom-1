import praktikum.Bun;

import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;

    private String actualName;
    private float actualPrice;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name ="Тест {index}: {0}, {1}")
    public static Object[][] getOrder() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},

        };
    }

    @Before
    public void bunCreation(){
        Bun bun = new Bun(name, price);
        actualName = bun.getName();
        actualPrice = bun.getPrice();
    }

    @Test
    public void runBunTest(){
        assertEquals("Ожидалось другое название булочки", name, actualName);
        assertEquals("Ожидалось другая цена булочки", price, actualPrice, 0.001f);
    }

}
