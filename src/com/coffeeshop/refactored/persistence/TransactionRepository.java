package com.coffeeshop.refactored.persistence;
 
import com.coffeeshop.refactored.model.Order;
public interface TransactionRepository {
    void save(Order order, double tax, double finalPrice);
}
