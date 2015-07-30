package it.salextax.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import it.salextax.function.RWReceipt;
import it.salextax.function.RWReceiptInterface;
import it.salextax.object.ShoppingCart;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;


public class ShoppingCartTest {
	
	private ShoppingCart shoppingCart;
	private RWReceiptInterface rw;
	private String inputFilePath = "input/input1.txt";
	private String fileExpectedTotal = "29.83";
	private String fileExpectedSalesTax = "1.50";

	@Before
	public void setUp() throws Exception {
		shoppingCart = new ShoppingCart();
		rw = new RWReceipt(inputFilePath,shoppingCart);
		rw.readProduct();
	}

	@Test
	public void testReceiptNotNull() {
		assertNotNull(rw);
	}

	@Test
	public void testReceiptTotal() {
		BigDecimal total = shoppingCart.calcolaTotaleTax();
		BigDecimal expectedTotal = new BigDecimal(fileExpectedTotal);
		assertEquals(total, expectedTotal);
	}

	@Test
	public void testReceiptSalesTax() {
		BigDecimal salesTax = shoppingCart.calcolaOnlyTax();
		BigDecimal expectedSalesTax = new BigDecimal(fileExpectedSalesTax);
		assertEquals(salesTax, expectedSalesTax);
	}

}
