package com.coffeeshop.refactored.persistence;
 
import com.coffeeshop.refactored.model.Order;
import java.io.FileWriter;
import java.io.IOException;
 
/**
 * Responsibility: persist transactions to a local text file. Nothing else.
 * Encapsulates all file-handling details (opening, writing, closing, errors)
 * so callers never need to know a text file is involved at all.
 */
public class FileTransactionRepository implements TransactionRepository {
 
    private final String filePath;
 
    public FileTransactionRepository(String filePath) {
        this.filePath = filePath;
    }
 
    public FileTransactionRepository() {
        this("orders_log.txt"); // default, matches original behavior
    }
 
    @Override
    public void save(Order order, double tax, double finalPrice) {
        System.out.println("[System] Saving transaction logs to disk...");
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write("Customer: " + order.getCustomerName()
                    + " | Item: " + order.getCoffeeType()
                    + " | Subtotal: " + order.getBasePrice()
                    + " | Tax: " + tax
                    + " | Total: " + finalPrice + "\n");
            System.out.println("[Database] Log successfully written to " + filePath);
        } catch (IOException e) {
            System.out.println("[CRITICAL ERROR] Failed to write to file system: " + e.getMessage());
        }
    }
}