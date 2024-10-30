// Question 2
// Purpose: Use abstract classes to calculate the income tax on yearly salary and sales tax on unit price of product

public interface Taxable {
    double SALES_TAX = 0.07;
    double INCOME_TAX = 0.105;

    double calcTax(); 
}
