package Util;

import java.util.List;

public class OrderHistory {

    private long userId;
    private List<Long> orderList;

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
}
