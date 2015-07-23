package it.salextax.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import it.salextax.exception.GenericException;
import it.salextax.function.RWReceipt;
import it.salextax.function.RWReceiptInterface;
import it.salextax.object.ShoppingCart;
import java.io.IOException;
import java.math.BigDecimal;

import org.junit.Test;

public class InputTests {

	@Test
	public void testInput1() throws NumberFormatException, IOException {
		ShoppingCart shoppingCart = new ShoppingCart();
		RWReceiptInterface rw = new RWReceipt("input/input1.txt", shoppingCart);
		rw.readProduct();
		BigDecimal total = shoppingCart.calcolaTotaleTax();
		BigDecimal myTotal = new BigDecimal("29.83");
		assertTrue(total.equals(myTotal));
	}

	@Test
	public void testInput2() throws  NumberFormatException, IOException {
		ShoppingCart shoppingCart = new ShoppingCart();
		RWReceiptInterface rw = new RWReceipt("input/input2.txt", shoppingCart);
		rw.readProduct();
		BigDecimal total = shoppingCart.calcolaTotaleTax();
		BigDecimal myTotal = new BigDecimal("65.15");
		assertTrue(total.equals(myTotal));
	}

	@Test
	public void testInput3() throws NumberFormatException, IOException {
		ShoppingCart shoppingCart = new ShoppingCart();
		RWReceiptInterface rw = new RWReceipt("input/input3.txt", shoppingCart);
		rw.readProduct();
		BigDecimal total = shoppingCart.calcolaTotaleTax();
		BigDecimal myTotal = new BigDecimal("74.68");
		assertTrue(total.equals(myTotal));
	}


	@Test
	public void testInvalidFile() throws GenericException {
		String invalidFilePath = "notExistFile.txt";
		ShoppingCart shoppingCart = new ShoppingCart();
		try {
			RWReceiptInterface rw = new RWReceipt(invalidFilePath, shoppingCart);
			rw.readProduct();
		} catch (Exception notFoundException) {
			assertEquals(notFoundException.getMessage(),"Errore: "+ invalidFilePath + " "
					+ "(Impossibile trovare il file specificato)");
		}
	}

}
