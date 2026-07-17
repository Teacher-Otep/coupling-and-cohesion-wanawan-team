package com.coffeeshop.refactored.pricing;
 
/**
 * Responsibility: apply local VAT to a base price. Nothing else.
 * If the tax rate or rule ever changes, only this class is touched.
 */
public class VatTaxCalculator implements TaxCalculator {
 
    private final double taxRate;
 
    public VatTaxCalculator(double taxRate) {
        this.taxRate = taxRate;
    }
 
    public VatTaxCalculator() {
        this(0.12); // default 12% VAT, matches original behavior
    }
 
    public double getTaxRate() {
        return taxRate;
    }
 
    @Override
    public double calculateTax(double basePrice) {
        return basePrice * taxRate;
    }
}