package it.salextax.object;

import java.math.BigDecimal;

import it.salextax.category.Book;
import it.salextax.category.Food;
import it.salextax.category.Medical;
import it.salextax.category.Other;


/**
 * @author 
 * 
 * Factory of Products
 *
 */
public class ProductFactory {

	private static ProductFactory instance;

	public static ProductFactory getInstance() {
		if (instance == null) {
			instance = new ProductFactory();
		}
		return instance;
	}

	private ProductFactory() {

	}

	public Product createProduct(String productType, String name, BigDecimal cost, int quantity,
			boolean isImported) {

		Product product = null;

		if (productType.equals(Constants.BOOK_PRODUCT)) {
			product = new Book(name, cost, quantity, isImported);
		} else if (productType.equals(Constants.FOOD_PRODUCT)) {
			product = new Food(name, cost, quantity, isImported);
		} else if (productType.equals(Constants.MEDICAL_PRODUCT)) {
			product = new Medical(name, cost, quantity, isImported);
		} else {
			product = new Other(name, cost, quantity, isImported);
		}

		return product;
	}

}
