package Util;

import models.Address;
import models.GroceryModel.Grocery;
import models.Reciept;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private long id;
    private Address address;
    private Reciept reciept;
    private List<Long> groceryList;
    private Date date;
    private Boolean isCanceled;

    public Order() {
        this.groceryList = new ArrayList<>();
    }

    public void addGrocery(final Grocery grocery)
    {

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

    public Reciept getReciept() {
        return reciept;
    }

    public void setReciept(Reciept reciept) {
        this.reciept = reciept;
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
