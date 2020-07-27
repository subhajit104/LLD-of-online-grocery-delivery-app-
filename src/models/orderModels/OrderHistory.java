package models.orderModels;

import models.orderModels.Order;
import userInterface.UI;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory {

    private long id;
    private long userId;
    private List<Long> orderList;

    public OrderHistory() {
        this.id = UI.uniqueId++;
        orderList = new ArrayList<>();
    }

    public void addOrder(Order order)
    {
        orderList.add(order.getId());
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<Long> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Long> orderList) {
        this.orderList = orderList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
