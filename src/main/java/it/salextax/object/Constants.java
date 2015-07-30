package it.salextax.object;

import java.math.BigDecimal;


/**
 * @author
 * 
 * Group of Constants
 *
 */
public class Constants {
	  
    public final static BigDecimal SALES_TAX_FREE = new BigDecimal(0);
	public final static BigDecimal SALES_TAX_FOR_DEFAULT = new BigDecimal(10);
	public final static BigDecimal IMPORT_DUTY_FOR_IMPORTED = new BigDecimal(5);
	public final static String BOOK_PRODUCT = "Book";
	public final static String FOOD_PRODUCT = "Food";
	public final static String MEDICAL_PRODUCT = "Medical";
	public final static String OTHER_PRODUCT = "Other";
	public final static int NEAREST_N_CENTS = 5;
	public final static int DECIMAL_PLACES = 2;
	public final static String imported = "imported";
	public final static String Imported = "Imported";
}
