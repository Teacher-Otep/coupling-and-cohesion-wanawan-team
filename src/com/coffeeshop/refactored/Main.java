package com.coffeeshop.refactored;
 
import com.coffeeshop.refactored.persistence.FileTransactionRepository;
import com.coffeeshop.refactored.pricing.VatTaxCalculator;
import com.coffeeshop.refactored.receipt.ReceiptPrinter;
 
public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor(
                new VatTaxCalculator(0.12),
                new ReceiptPrinter(),
                new FileTransactionRepository("orders_log.txt")
        );
 
        processor.processOrder("Juan Dela Cruz", "Caramel Macchiato", 150.00);
    }
}