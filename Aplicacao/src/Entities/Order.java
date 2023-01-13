package Entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
        private Date moment;
        private OrderStatus status;
        private List<OrderItem> orderItemList = new ArrayList<>();
        private Client client;

        public Order(){
        }

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem item){
            orderItemList.add(item);
    }

    public void removeItem(OrderItem item){
        orderItemList.remove(item);
    }

    public double total(){
            double sum = 0.0;

            for (OrderItem c : orderItemList){
                sum += c.subTotal();
            }
            return sum;
    }

    public String toString(){
             StringBuilder sb = new StringBuilder();
             sb.append("ORDER SUMMARY:\nOrder moment: " + moment + "\nOrder status: " + status +
             "\n" + client.toString()
             + "\nOrder items:");

             for (OrderItem c : orderItemList){
                 sb.append("\nProduto: " + c.getProduct().getName() + " - Quantidade: " + c.getQuantity() + " - Subtotal: " + c.subTotal() + "\n");
             }
             sb.append("Total: " + total());
             return sb.toString();
        }
}
