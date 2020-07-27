package models.orderModels;

import models.orderModels.Order;

import java.util.Set;

public class WishList {

    private long userId;
    private Set<Long> orderIds;

    public void addWish(final Order order)
    {
        orderIds.add(order.getId());
    }
    public void removeItem(final Order order)
    {
        orderIds.remove(order.getId());
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Set<Long> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(Set<Long> orderIds) {
        this.orderIds = orderIds;
    }
}
