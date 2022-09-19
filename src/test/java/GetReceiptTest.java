import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

@RunWith(MockitoJUnitRunner.class)
public class GetReceiptTest {
  @Mock
  private Bun bun;
  @Mock
  private Ingredient ingredient;
  private Burger burger;

  @Test
  public void getReceiptTest() {
    burger = new Burger();
    burger.setBuns(bun);
    burger.addIngredient(ingredient);
    Mockito.when(bun.getName()).thenReturn("bunNameTest");
    Mockito.when(ingredient.getType()).thenReturn(SAUCE);
    Mockito.when(ingredient.getName()).thenReturn("hot sauce");
    Mockito.when(bun.getPrice()).thenReturn(500F);
    Mockito.when(ingredient.getPrice()).thenReturn(200F);
    String actual = burger.getReceipt();
    String expected = "(==== bunNameTest ====)\r\n"
        + "= sauce hot sauce =\r\n"
        + "(==== bunNameTest ====)\r\n"
        + "\r\n"
        + "Price: 1200,000000\r\n";

    assertEquals("Incorrect value", expected, actual);
  }
}
