package seedu.duke.command;

import seedu.duke.data.Menu;
import seedu.duke.data.dish.Dish;
import seedu.duke.ui.Ui;

/**
 * Edit the price of a dish of a certain index
 */
public class EditPriceCommand extends Command {
    public static final String COMMAND_WORD = "edit_price";
    private final int menuID;
    private final float newPrice;

    public EditPriceCommand(int menuID, float newPrice) {
        this.menuID = menuID;
        this.newPrice = newPrice;
    }

    /**
     * Set new price of the dish and show edit price message
     * @param menu menu of the current session
     * @param ui ui of the current session
     */
    public void execute(Menu menu, Ui ui) {
        Dish dish = menu.getDish(this.menuID);
        dish.setPrice(this.newPrice);

        Ui.showEditPriceMessage(dish.toString());
    }
}
