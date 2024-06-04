package sparta.service;

import sparta.enumtype.OrderStatus;

public class Order {
    private String prodcutName;
    private OrderStatus status;

    public Order(String prodcutName, OrderStatus status) {
        this.prodcutName = prodcutName;
        this.status = status;
    }

    public boolean isChangable(OrderStatus nextStatus) {
        return status.isChangeableStatus(nextStatus);
    }

}
