package com.coffeeshop.refactored.receipt;
 
import com.coffeeshop.refactored.model.Order;
public class ReceiptPrinter {
 
    public void print(Order order, double tax, double finalPrice) {
        System.out.println("\n===== COFFEE SHOP RECEIPT =====");
        System.out.println("Customer: " + order.getCustomerName());
        System.out.println("Beverage: " + order.getCoffeeType());
        System.out.println("Subtotal: PHP " + order.getBasePrice());
        System.out.println("Tax Amount: PHP " + tax);
        System.out.println("Total Amount : PHP " + finalPrice);
        System.out.println("================================\n");
    }
}
