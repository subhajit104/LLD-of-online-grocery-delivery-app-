package models;

import Util.Order;

public class Receipt {

    private String mailAddress;
    private Order order;

    public Receipt(String mailAddress, Order order) {
        this.mailAddress = mailAddress;
        this.order = order;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "mailAddress='" + mailAddress + '\'' +
                ", order=" + order +
                '}';
    }
}
