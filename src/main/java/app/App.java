package app;

import jencapsulation.Product;

public class App {

	public static void main(String[] args) {
		
		Product product1 = new Product();
		product1.setName("iPhone 12");
		System.out.println("name of product1: " + product1.getName());
		
		Product product2 = new Product();
		product2.setName("iPhone 12 Pro");
		System.out.println("name of product2: " + product2.getName());
	}

}