package models.orderModels;

import userInterface.UI;

import java.util.HashMap;
import java.util.Map;

public class OrderHistory {

    private long id;
    private Map<Long,Order> orderList;

    public OrderHistory() {
        this.id = UI.uniqueId++;
        orderList = new HashMap<>();
    }

    public void addOrder(Order order)
    {
        System.out.println("Order added to the history");
        System.out.println("Details:");
        System.out.println(order.toString());

        orderList.put(order.getId(),order);
    }

    private Order findOrderById(Long id)
    {
        Order savedOrder = orderList.get(id);
        return null;
    }
    public void cancelOrder(long id)
    {
        System.out.println("cancel ordered");
        System.out.println("Details");


        Order savedOrder = findOrderById(id);
        System.out.println(savedOrder.toString());
        savedOrder.setStatus(Status.CANCELED);
    }

    public void returnOrder(long id)
    {
        System.out.println("cancel ordered");
        System.out.println("Details");
        Order savedOrder = findOrderById(id);
        savedOrder.setStatus(Status.RETURNED);
        System.out.println(savedOrder.toString());
    }

}
