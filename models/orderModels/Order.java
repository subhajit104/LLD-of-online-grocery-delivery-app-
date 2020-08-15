package models.orderModels;

import Util.Address;
import models.GroceryModel.Grocery;
import userInterface.UI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private long id;
    private Address address;
    private Grocery grocery;
    private Date date;
    private Status status;
    private float totalAmount;

    public Order() {
        this.id = UI.uniqueId++;
        date = new Date();
        status = Status.PLACED;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setGrocery(Grocery grocery) {
        this.grocery = grocery;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Grocery getGrocery() {
        return grocery;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public Date getDate() {
        return date;
    }

    public Status getStatus() {
        return status;
    }
}
