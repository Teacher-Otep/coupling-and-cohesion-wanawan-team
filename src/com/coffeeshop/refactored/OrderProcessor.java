package com.coffeeshop.refactored;
 
import com.coffeeshop.refactored.model.Order;
import com.coffeeshop.refactored.persistence.TransactionRepository;
import com.coffeeshop.refactored.pricing.TaxCalculator;
import com.coffeeshop.refactored.receipt.ReceiptPrinter;

public class OrderProcessor {
 
    private final TaxCalculator taxCalculator;
    private final ReceiptPrinter receiptPrinter;
    private final TransactionRepository transactionRepository;
 
    public OrderProcessor(TaxCalculator taxCalculator,
                           ReceiptPrinter receiptPrinter,
                           TransactionRepository transactionRepository) {
        this.taxCalculator = taxCalculator;
        this.receiptPrinter = receiptPrinter;
        this.transactionRepository = transactionRepository;
    }
 
    public void processOrder(String customerName, String coffeeType, double price) {
        Order order = new Order(customerName, coffeeType, price);
 
        System.out.println("[System] Calculating final totals...");
        double tax = taxCalculator.calculateTax(order.getBasePrice());
        double finalPrice = order.getBasePrice() + tax;
 
        receiptPrinter.print(order, tax , finalPrice);
 
        transactionRepository.save(order, tax , finalPrice);
    }
}
