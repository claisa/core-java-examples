package customannotations;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * Handles the Size Annotation.
 */
public class SizeHandler {
	

	/**
	 * Checks the length of a String field.
	 * If the field is not a String or is null, 
	 * the Size annotation is ignored.
	 * @param object - Object with field Size annotation
	 * @throws SizeException
	 */
	public void checkSize(Object object) throws SizeException {
    	try {
			checkIfNull(object);
			checkLength(object);

		} catch (Exception e) {
			throw new SizeException(e.getMessage());
		}
	}
	
	
   
    /**
     * @param object - Object with field Size annotation
     */
    private void checkIfNull(Object object) {
    	if (Objects.isNull(object)) {
        	throw new SizeException("The object is null - Size annotation not applied.");
        }
    }
    
    
    /**
     * Checks the length of the field 
     * @param object - Object with field Size annotation
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    private void checkLength(Object object) throws IllegalArgumentException, IllegalAccessException{

    	//get fields from the class
    	Field[] fields = object.getClass().getDeclaredFields();

    	//if the class have at least one field
    	for (Field field : fields) {

    		//access modifier of fields could be private 
    		field.setAccessible(true);

    		//analyzes only fields with Size annotation
    		if (field.isAnnotationPresent(Size.class)) {
    			
    			
    			//if the field object is a String
    			if ( field.get(object) != null && field.get(object) instanceof String ) {
    				
    				String fieldObject = (String) field.get(object);
    				int len = fieldObject.length();
    				Size sizeAnnotation = field.getAnnotation(Size.class);
    				
    				//check min and max
    				checkMaxMin(len,sizeAnnotation, field.getName());
    				
    				
    			}
    		}
    	}
    }
    
    
    
    /**
     * Checks if both values (min,max) are correctly defined
     * @param sizeAnnotation
     */
    private void checkMaxMin(int len, Size sizeAnnotation, String fieldName) {
    	
    	int maxLen = sizeAnnotation.max();
		int minLen = sizeAnnotation.min();
		
		if ( (maxLen == -1 || minLen == -1) || (maxLen < minLen) ) {
			throw new SizeException("Min and Max not correctly defined in " + fieldName);
		}
		if (len < minLen || len > maxLen  ){
			throw new SizeException("Size criteria of " + fieldName + " not met -> "
					+ "Max_Length= " + maxLen 
					+ " Min_Length= " + minLen );
		}
    	
    }


}

