package it.salextax.category;

import java.math.BigDecimal;

import it.salextax.object.Constants;
import it.salextax.object.Product;

/**
 * @author 
 * 
 * Category Medical
 *
 */
public class Medical extends Product {

	private BigDecimal salesTaxPercent = Constants.SALES_TAX_FREE;

	public Medical(String name, BigDecimal cost, int quantity, boolean isImported) {
		super(name, cost, quantity, isImported);
		super.setSalesTaxPercent(this.salesTaxPercent);
	}

}
