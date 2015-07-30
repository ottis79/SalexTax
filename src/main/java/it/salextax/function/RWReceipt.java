package it.salextax.function;

import it.salextax.exception.GenericException;
import it.salextax.object.Category;
import it.salextax.object.Constants;
import it.salextax.object.Product;
import it.salextax.object.ProductFactory;
import it.salextax.object.ShoppingCart;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Arrays;


/**
 * @author
 *
 * Class to read the data and Write Results
 */
public class RWReceipt implements RWReceiptInterface {

	String pathFileInput;
	String pathFileOutput;
	ShoppingCart shoppingCart;
	Category category;
	ProductFactory productFactory;
	
	/**
	 * Constructor
	 * 
	 * @param pathFileInput
	 * @param shoppingCart
	 */
	public RWReceipt(String pathFileInput, ShoppingCart shoppingCart) {
		this.pathFileInput = pathFileInput;
		this.shoppingCart = shoppingCart;
	}
	
	/**
	 * Constructor
	 * 
	 * @param pathFileInput
	 * @param pathFileOutput
	 * @param shoppingCart
	 */
	public RWReceipt(String pathFileInput, String pathFileOutput,
			ShoppingCart shoppingCart) {
		this.pathFileInput = pathFileInput;
		this.pathFileOutput = pathFileOutput;
		this.shoppingCart = shoppingCart;
	}

	public void readProduct() {
		try {
			FileInputStream fstream = new FileInputStream(pathFileInput);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null)
				put(strLine);
			in.close();
		} catch (Exception e) {
			throw new GenericException("Errore: " + e.getMessage());
		}
	}

	public void writeProduct() {
		try {
			FileOutputStream prova = new FileOutputStream(pathFileOutput);
			PrintStream write = new PrintStream(prova);
			for (Product element : shoppingCart.getListofProduct())
				write.println(element.toString());
			write.println("Sales Taxes: "+shoppingCart.calcolaOnlyTax().toString());
			write.println("Total: "+shoppingCart.calcolaTotaleTax().toString());
			write.close();
		} catch (IOException e) {
			throw new GenericException("Errore: " + e.getMessage());
		}
	}

	private void put(String line) {
		try {
			int quantity = 0;
			double price = 0;
				line = line.replaceAll("\\s+$", "");
				String[] array = line.split(" ");
				if (isNumber(array[0]) && isNumber(array[array.length - 1])) {
					quantity = new Integer(array[0]).intValue();
					price = new Double(array[array.length - 1]).doubleValue();
				} else {
					quantity = 0;
					price = 0;
					throw new GenericException();
				}
				String[] product = Arrays.copyOfRange(array, 1, array.length - 2);
				String productDescription = "";
				for (int index = 0; index < product.length; index++) {
					productDescription += " " + product[index].toLowerCase();
				}
				boolean isImported = productDescription.contains(Constants.imported)
						|| productDescription.contains(Constants.Imported);
				shoppingCart.addProduct(ProductFactory.getInstance().createProduct(Category.getInstance().getCategoryFor(productDescription), productDescription, new BigDecimal(price),
						quantity, isImported));
		} catch (Exception e) {
			throw new GenericException("Errore: " + e.getMessage());
		}
	}
	
	private boolean isNumber(String string) {
		boolean isNumber = true;
		try {
			Double.parseDouble(string);
		} catch (NumberFormatException e) {
			isNumber = false;
		}
		return isNumber;
	}

}
