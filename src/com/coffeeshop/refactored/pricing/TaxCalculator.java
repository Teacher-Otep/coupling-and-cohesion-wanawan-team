package com.coffeeshop.refactored.pricing;
 
/**
 * Abstraction for tax/pricing rules.
 * Depending on this interface (rather than a concrete class) keeps
 * OrderProcessor decoupled from *how* tax is calculated.
 *
 * Returns only the tax AMOUNT (not the final price), so the base price
 * and the tax stay clearly separate — the caller decides how to combine them.
 */
public interface TaxCalculator {
    double calculateTax(double basePrice);
}