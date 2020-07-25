package models;
import models.GroceryModel.Grocery;
import java.util.HashSet;
import java.util.Set;

public class Cart {

    private float totalAmount;
    private Set<Long> groceries;
    private long userId;

    public Cart() {
        groceries = new HashSet<>();
    }

    public void addGrocery(final Grocery grocery)
    {
        groceries.add(grocery.getId());
        totalAmount += grocery.getPrice();
    }

    public void removeGrocery(final Grocery grocery)
    {
        groceries.remove(grocery.getId());
        totalAmount -= grocery.getPrice();
    }

}
