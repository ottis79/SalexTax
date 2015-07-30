package it.salextax.object;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * 
 * Class to store the receipt with all products
 *
 */
public class ShoppingCart {
	ArrayList<Product> listofProduct;
	
	public ShoppingCart() {
		this.listofProduct = new ArrayList<Product>();;
	}

	/**
	 * @return total Price with Tax
	 */
	public BigDecimal calcolaTotaleTax(){
		BigDecimal tot= new BigDecimal(0);
		for (Product element : listofProduct)
			tot=tot.add(element.getCost().add(element.getSalesTax()));
		return tot;	
	}
	
	/**
	 * @return total Tax
	*/
	public BigDecimal calcolaOnlyTax(){
		BigDecimal tot= new BigDecimal(0);
		for (Product element : listofProduct)
			tot=tot.add(element.getSalesTax());
		return tot;	
	} 

	/**
	 * @return list of Products
	 */
	public ArrayList<Product> getListofProduct() {
		return listofProduct;
	}

	/**
	 * @param listofProduct
	 * 
	 * Set list of products
	 */
	public void setListofProduct(ArrayList<Product> listofProduct) {
		this.listofProduct = listofProduct;
	}
	
	/**
	 * @param p
	 * 
	 * Add Product 
	 */
	public void addProduct(Product p){
		listofProduct.add(p);
	}
	
	/**
	 * Empty Cart
	 */
	public void emptyCart(){
		listofProduct.clear();
	}
}
