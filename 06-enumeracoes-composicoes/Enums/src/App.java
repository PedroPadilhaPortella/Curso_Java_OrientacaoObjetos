import java.util.Date;

import entities.Order;
import entities.OrderStatus;

public class App {
    public static void main(String[] args) throws Exception {

        Order order = new Order(1092, new Date(), OrderStatus.PENDING_PAYMENT);
        System.out.println(order);

        OrderStatus os1 = OrderStatus.PROCESSING;
        OrderStatus os2 = OrderStatus.valueOf("DELIVERED");

        System.out.println(os1);
        System.out.println(os2);
    }
}
