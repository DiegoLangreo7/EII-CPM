package uo.cpm.model;

import java.util.*;

import uo.cpm.util.FileUtil;


public class Menu {
	
	private static final String PRODUCTS_FILE = "files/articulos.dat";
	private List<Product> productsList = null;
	
	public Menu(){
		productsList = new ArrayList<Product>();
		loadProducts();
	}

	private void loadProducts(){
		FileUtil.loadFile (PRODUCTS_FILE, productsList);
	  }

	public Product[] getProducts(){
		Product[] products = productsList.toArray(new Product[productsList.size()]);
		return products;	
	}
	
}
