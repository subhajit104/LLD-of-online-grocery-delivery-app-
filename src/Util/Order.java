package Util;

import models.Address;
import models.GroceryModel.Grocery;
import models.Receipt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private long id;
    private Address address;
    private List<Long> groceryList;
    private Date date;
    private Boolean isCanceled;

    public Order() {
        this.groceryList = new ArrayList<>();
    }

    public void addGrocery(final Grocery grocery)
    {
          groceryList.add(grocery.getId());

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Long> getGroceryList() {
        return groceryList;
    }

    public void setGroceryList(List<Long> groceryList) {
        this.groceryList = groceryList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getCanceled() {
        return isCanceled;
    }

    public void setCanceled(Boolean canceled) {
        isCanceled = canceled;
    }
}
