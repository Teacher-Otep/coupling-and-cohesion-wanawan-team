package com.coffeeshop.refactored;
 
import com.coffeeshop.refactored.model.Order;
import com.coffeeshop.refactored.persistence.TransactionRepository;
import com.coffeeshop.refactored.pricing.TaxCalculator;
import com.coffeeshop.refactored.receipt.ReceiptPrinter;
 
/**
 * Responsibility: coordinate the order workflow — nothing more.
 * It no longer knows HOW tax is computed, HOW a receipt is formatted,
 * or HOW/WHERE data is stored. It only knows the sequence of steps.
 *
 * Collaborators are injected via the constructor (dependency injection),
 * so OrderProcessor is coupled only to interfaces, not concrete
 * implementations. Any collaborator can be swapped or mocked in tests
 * without touching this class.
 */
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