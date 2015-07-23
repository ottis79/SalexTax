package it.salextax.object;

import java.math.BigDecimal;

/**
 * @author
 * 
 * Class management products 
 *
 */
public abstract class Product {
	private String name;
	private BigDecimal cost;
	private BigDecimal salesTaxPercent;
	private int quantity;
	private boolean isImported;

	public Product(String name, BigDecimal cost, int quantity, boolean isImported) {
		this.name = name;
		this.cost = cost;
		this.quantity = quantity;
		this.salesTaxPercent = Constants.SALES_TAX_FOR_DEFAULT;
		this.isImported = isImported;
	}

	/**
	 * @return Cost of Product
	 */
	public BigDecimal getCost() {
		return this.cost.multiply(new BigDecimal(this.quantity)).setScale(Constants.DECIMAL_PLACES,BigDecimal.ROUND_HALF_UP);
	}

	public String getName() {
		return this.name;
	}

	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * @return Tax of Product
	 */
	public BigDecimal getSalesTax() {
		BigDecimal totalSalesTaxForThisProduct;
		if (isImported) {
			totalSalesTaxForThisProduct = ((this.salesTaxPercent.add(Constants.IMPORT_DUTY_FOR_IMPORTED))
					.multiply(this.cost.multiply(new BigDecimal(this.quantity)))).divide(new BigDecimal(100));

		} else
			totalSalesTaxForThisProduct = (this.salesTaxPercent.multiply(this.cost).multiply(new BigDecimal(this.quantity))).divide(new BigDecimal(100));

		return roundUpSalesTax(totalSalesTaxForThisProduct, Constants.NEAREST_N_CENTS).setScale(Constants.DECIMAL_PLACES,BigDecimal.ROUND_HALF_UP);
	}

	public boolean isImported() {
		return this.isImported;
	}

	private BigDecimal roundUpSalesTax(BigDecimal totalSalesTaxForThisProduct, int nearestFiveCents) {
		double scaledNumber = totalSalesTaxForThisProduct.setScale(Constants.DECIMAL_PLACES,
				BigDecimal.ROUND_HALF_UP).doubleValue() * 100;
		double resolution = scaledNumber % Constants.NEAREST_N_CENTS;
		if (resolution != 0) {
			scaledNumber += Constants.NEAREST_N_CENTS - resolution;
		}
		return new BigDecimal(scaledNumber / 100);
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setSalesTaxPercent(BigDecimal salesTaxPercent) {
		this.salesTaxPercent = salesTaxPercent;
	}
	
	@Override
	public String toString() {
		return  quantity+name+": "
				+ getCost().add(getSalesTax()).toString();
	}
}
