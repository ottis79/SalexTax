package it.salextax.object;

import java.util.HashMap;


/**
 * @author
 * 
 * Class of Category of Product
 *
 */
public class Category {

	private static Category instance;
	private static HashMap<String, String> itemCategoriesMap;

	public static Category getInstance() {
		if (instance == null) {
			instance = new Category();
		}
		return instance;
	}

	private Category() {
		itemCategoriesMap = new HashMap<String, String>();
		itemCategoriesMap.put("book", Constants.BOOK_PRODUCT);
		itemCategoriesMap.put("books", Constants.BOOK_PRODUCT);
		itemCategoriesMap.put("chocolate", Constants.FOOD_PRODUCT);
		itemCategoriesMap.put("chocolates", Constants.FOOD_PRODUCT);
		itemCategoriesMap.put("music", Constants.OTHER_PRODUCT);
		itemCategoriesMap.put("perfume", Constants.OTHER_PRODUCT);
		itemCategoriesMap.put("pills", Constants.MEDICAL_PRODUCT);
	}

	public void addProduct(String item, String category) {
		itemCategoriesMap.put(item, category);
	}

	public void removeProduct(String productName) {
		if (itemCategoriesMap.containsKey(productName))
			itemCategoriesMap.remove(productName);
	}

	public String getCategoryFor(String productDescription) {
		String[] productKeyWords = productDescription.split(" ");
		String category = Constants.OTHER_PRODUCT;
		for (int keyWordIndex = 0; keyWordIndex < productKeyWords.length; keyWordIndex++) {
			if (itemCategoriesMap.containsKey(productKeyWords[keyWordIndex])) {
				category = itemCategoriesMap.get(productKeyWords[keyWordIndex]);
			}
		}
		return category;
	}

}
