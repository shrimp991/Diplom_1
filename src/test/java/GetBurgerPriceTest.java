import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class GetBurgerPriceTest {
    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void getBurgerPriceTest(){
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(50F);
        Mockito.when(ingredient.getPrice()). thenReturn(100F);
        float expectedPrice = 200;

        assertEquals("Incorrect value", expectedPrice, burger.getPrice(), 0);
    }
}
