package models.orderModels;
import models.GroceryModel.Grocery;
import userInterface.UI;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cart {

    private long id;
    private float totalAmount;
    private Set<Long> groceries;
    private long userId;

    public Cart() {

        this.id = UI.uniqueId++;
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

    @Override
    public String toString() {
        return "Cart{" +
                "totalAmount=" + totalAmount +
                ", number of groceries=" + groceries.size() +
                ", userId=" + userId +
                '}';
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Long> getGroceries() {
        return groceries.stream().collect(Collectors.toList());
    }

    public void setGroceries(Set<Long> groceries) {
        this.groceries = groceries;
    }
}
