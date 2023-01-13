package Main;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Entities.Client;
import Entities.Order;
import Entities.OrderItem;
import Entities.OrderStatus;
import Entities.Product;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter cliente data:\n");
        System.out.print("Name:");
        String name = sc.next();
        System.out.print("Email:");
        String email = sc.next();
        System.out.print("Birth date (DD/MM/YYYY):");
        Date birthDate = sdf.parse(sc.next());
        Client client = new Client(name, email, birthDate);

        System.out.print("Enter order data:\n");
        System.out.print("STATUS:");
        String status = sc.next();
        System.out.print("How many items to this order?");
        int itemOrders = sc.nextInt();
        Date date = new Date();

        Order order = new Order(date, OrderStatus.valueOf(status), client);
        for (int i = 1; i<=itemOrders; i++){


            System.out.print("Enter #" + i + "item data:" );
            System.out.print("\nProduct name:");
            String productName = sc.next();
            System.out.print("Product price:");
            Double productPrice = sc.nextDouble();
            System.out.print("Quantity:");

            int productQuantity = sc.nextInt();
            Product product = new Product(productName, productPrice);
            OrderItem orderItem = new OrderItem(productQuantity, productPrice, product);
            order.addItem(orderItem);
            

        }

            System.out.print(order.toString());
         
            sc.close();
    }
    
}