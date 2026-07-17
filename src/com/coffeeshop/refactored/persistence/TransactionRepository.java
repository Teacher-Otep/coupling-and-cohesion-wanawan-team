package com.coffeeshop.refactored.persistence;
 
import com.coffeeshop.refactored.model.Order;
 
/**
 * Abstraction for persisting a completed transaction.
 * Swapping a text file for a database or REST API later means
 * writing a new implementation of this interface — nothing else changes.
 */
public interface TransactionRepository {
    void save(Order order, double tax, double finalPrice);
}