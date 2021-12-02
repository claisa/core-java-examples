package apptests;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


import customannotations.SizeException;
import customannotations.SizeHandler;
import jencapsulation.Product;

/*
 *   field String name: 		Length is between 3 and 25
 *   field String category:		Length is between 3 and 35
 */

	public class ProductTest {
		
		
		@Test
	    public void testSizeNotCorrectMax() throws SizeException {

			Product product3 = new Product();
			product3.setName("123456789101112131415166443344666767");
	        
			var error = assertThrows(
	                SizeException.class,
	                () -> new SizeHandler().checkSize(product3));

	        assertTrue(error.getMessage().startsWith("Size criteria of name not met -> Max_Length= 25 Min_Length= 3"));
	    }
		
		
		
		
		@Test
	    public void testSizeNotCorrectMin() throws SizeException {

			Product product4 = new Product();
	        product4.setCategory("a");
	        
			var error = assertThrows(
	                SizeException.class,
	                () -> new SizeHandler().checkSize(product4));

			assertTrue(error.getMessage().startsWith("Size criteria of category not met -> Max_Length= 45 Min_Length= 3"));
	    }
		
		
	}

