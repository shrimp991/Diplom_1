import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

public class AddMoveRemoveIngredientTest {
  Database database;
  Burger burger;
  List<Ingredient> ingredients;

  @Before
  public void setUp() {
    database = new Database();
    burger = new Burger();
    ingredients = database.availableIngredients();
  }

  @Test
  public void addIngredientTest() {
    burger.addIngredient(ingredients.get(0));
    String actual = burger.ingredients.get(0).getName();
    String expected = "hot sauce";

    assertEquals("Incorrect value", expected, actual);
  }

  @Test
  public void moveIngredientTest() {
    burger.addIngredient(ingredients.get(0));
    burger.addIngredient(ingredients.get(1));
    burger.moveIngredient(0, 1);
    String actual = burger.ingredients.get(0).getName();
    String expected = "sour cream";

    assertEquals("Incorrect value", expected, actual);
  }

  @Test
  public void removeIngredientTest() {
    burger.addIngredient(ingredients.get(0));
    burger.removeIngredient(0);

    assertTrue(burger.ingredients.isEmpty());
  }
}
