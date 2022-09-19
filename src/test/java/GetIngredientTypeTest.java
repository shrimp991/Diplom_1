import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class GetIngredientTypeTest {

  private Ingredient ingredient;
  private String expectedIngredientType;

  public GetIngredientTypeTest(Ingredient ingredient, String expectedIngredientType) {
    this.ingredient = ingredient;
    this.expectedIngredientType = expectedIngredientType;
  }

  @Parameterized.Parameters(name = "Тестовые данные: getType: {1}")
  public static Object[][] checkIngredientType() {
    return new Object[][]{
        {new Ingredient(IngredientType.SAUCE, "some sauce", 123F), "SAUCE"},
        {new Ingredient(IngredientType.FILLING, "some filling", 123F), "FILLING"}
    };
  }

  @Test
  public void checkGetIngredientTypeTestIsCorrect() {
    String actualIngredientType = ingredient.getType().name();
    assertEquals("Incorrect value", expectedIngredientType, actualIngredientType);
  }
}
