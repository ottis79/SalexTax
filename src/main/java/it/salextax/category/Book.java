package it.salextax.category;

import java.math.BigDecimal;

import it.salextax.object.Constants;
import it.salextax.object.Product;


/**
 * @author 
 * 
 * Category Book
 *
 */
public class Book extends Product {

	private BigDecimal salesTaxPercent = Constants.SALES_TAX_FREE;

	public Book(String title, BigDecimal cost, int quantity, boolean isImported) {
		super(title, cost, quantity, isImported);
		super.setSalesTaxPercent(this.salesTaxPercent);
	}

}
