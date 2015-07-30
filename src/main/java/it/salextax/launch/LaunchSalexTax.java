package it.salextax.launch;

import it.salextax.function.RWReceipt;
import it.salextax.function.RWReceiptInterface;
import it.salextax.object.ShoppingCart;

/**
 * @author
 *
 * Execute
 */
public class LaunchSalexTax {

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("start.......");
		ShoppingCart shoppingCart = new ShoppingCart();
		RWReceiptInterface rw = null;
		for (int i = 1; i <= 3; i++) {
			rw = new RWReceipt("input/input"+i+".txt", "output/output"+i+".txt",
					shoppingCart);
			rw.readProduct();
			rw.writeProduct();
			shoppingCart.emptyCart();
		}
		System.out.println("end.......");
	}

}
