package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.data.Menu;
import seedu.duke.data.dish.Dish;
import seedu.duke.data.dish.Ingredient;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ListIngredientCommandTest {
    @Test
    public void execute_validIndex_printsIngredients() {
        ArrayList<Dish> menuItems = new ArrayList<>();
        menuItems.add(new Dish("Chicken Rice", new ArrayList<>(Arrays.asList(new Ingredient("Rice", "1 cup"), new Ingredient("Chicken", "100g"))), 8.0F));
        menuItems.add(new Dish("Chicken Sandwich", new ArrayList<>(Arrays.asList(new Ingredient("Lettuce", "100g"), new Ingredient("Chicken", "50g"))), 5.0F));
        Menu menu = new Menu(menuItems);

        List<String> actualOutput = new ArrayList<>();
        Ui ui = new Ui() {
            @Override
            public void showToUser(String... message) {
                actualOutput.addAll(Arrays.asList(message));
            }
        };

        int indexToSelect = 1;
        ListIngredientCommand listIngredientCommand = new ListIngredientCommand(indexToSelect);
        listIngredientCommand.execute(menu, ui);

        String expectedOutput = "Chicken Rice Ingredients: \n" +
                "Rice - 1 cup\n" +
                "Chicken - 100g\n";

        assertEquals(expectedOutput.trim().replaceAll("\\s+", " "), actualOutput.get(0).trim().replaceAll("\\s+", " "));
    }

    public void execute_invalidIndex_returnsErrorMessage() {
        ArrayList<Dish> menuItems = new ArrayList<>();
        menuItems.add(new Dish("Chicken Rice", new ArrayList<>(Arrays.asList(new Ingredient("Rice", "1 cup"), new Ingredient("Chicken", "100g"))), 8.0F));
        menuItems.add(new Dish("Chicken Sandwich", new ArrayList<>(Arrays.asList(new Ingredient("Lettuce", "100g"), new Ingredient("Chicken", "50g"))), 5.0F));
        Menu menu = new Menu(menuItems);
        Ui ui = new Ui();
        int invalidIndex = 3;

        assertThrows(IllegalArgumentException.class, () -> {
            ListIngredientCommand listIngredientCommand = new ListIngredientCommand(invalidIndex);
            listIngredientCommand.execute(menu, ui);
        });
    }
}
