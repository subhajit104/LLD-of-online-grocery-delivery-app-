package models.orderModels;
import models.GroceryModel.Grocery;
import userInterface.UI;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

public class Cart {

    private long id;
    private float totalAmount;
    private List<Long> groceries;

    public Cart() {

        this.id = UI.uniqueId++;
        groceries = new ArrayList<>();
        totalAmount = 0;
    }

    public void addGrocery(final Grocery grocery)
    {
        System.out.println("Grocery added");
        System.out.println("details:");
        System.out.println(grocery.toString());

        groceries.add(grocery.getId());
        totalAmount += grocery.getPrice();
    }

    public void removeGrocery(final Grocery grocery)
    {

        groceries.remove(grocery.getId());
        totalAmount -= grocery.getPrice();

        System.out.println("Removed Grocery");
        System.out.println("Details");
        System.out.println(grocery.toString());

    }

    public List<Long> getGroceryList() {
        return groceries.stream().collect(Collectors.toList());
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
        return groceries;
    }
    public void clearCart(){
        groceries.clear();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalAmount=" + totalAmount +
                ", number of groceries=" + groceries.size() +
                '}';
    }




}
