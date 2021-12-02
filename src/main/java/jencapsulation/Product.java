package jencapsulation;

import customannotations.Size;

/** 
 * 
 * Product has private fields/properties: name, category and price and 
 * is a fully encapsulated class (public getter and setter methods are 
 * used to access and update the value of the private fields)
 * 
 * @author Claudia Moreira
 * @version 1.0
*/
public class Product {
	
	//length is between 3 and 25
	@Size(min=3, max=25)
	private String name;
	
	//length is between 3 and 45
	@Size(min=3,max=45)
	private String category;
	
	
	//
	private float price;
	
	
	
	//getters
	/**
	 * @return name - name of the product
	 */
	public String getName() { 
		return name; 
	}
	/**
	 * @return category - category of the product
	 */
	public String getCategory() { 
		return category; 
	}
	/**
	 * @return price - price of the product
	 */
	public float getPrice() { 
		return price; 
	}

	
	//setters
	/**
	 * @param name of the product - length of name  
	 * can be defined by Size Annotation
	 */
	public void setName(String name) { 
		this.name = name; 
	}
	/**
	 * @param category of the product - length of category 
	 * can be defined by Size Annotation 
	 */
	public void setCategory(String category) { 
		this.category = category;
	}
	/**
	 * @param price of the product
	 */
	public void setPrice(float price) { 
		this.price = price; 
	}
}

