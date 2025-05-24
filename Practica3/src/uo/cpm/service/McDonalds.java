package uo.cpm.service;

import uo.cpm.model.Menu;
import uo.cpm.model.Order;
import uo.cpm.model.Product;

public class McDonalds {

	Menu menu = new Menu();
	Order order = new Order();
	
	public McDonalds() {
		
		
	}

	public Product[] getMenuProducts()
	{
		return menu.getProducts();
	}

	public void initOrder()
	{
		order.initialize();
	}
	
	public String getOrderCode()
	{
		return order.getCode();
	}
	
	public void addToOrder ( Product p, Integer units )
	{
		order.add(p, units);
	}
	
	public void saveOrder()
	{
		order.saveOrder();
	}

	public Object getOrderTotal() {
		// TODO Auto-generated method stub
		return order.getPrice();
	}
	
	public int getUnidades(Product producto) {
		if(producto == null) {
			return 0;
		}
		return order.getNumberOfProduct(producto);
		
	}
	
	
}
