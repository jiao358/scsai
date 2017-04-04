package scsai.cmb.helper;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class CmbProperty extends PropertyPlaceholderConfigurer {
	private static final String regex="^\\$\\{.+\\}$";
	
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		String returnPropertyValue="";
		if(propertyValue.matches(regex)){
			returnPropertyValue = TokenEntrypt.decrypt(propertyValue.substring(2,propertyValue.length()-1));
		}else{
			returnPropertyValue=propertyValue;
		}
		
		return returnPropertyValue;
	}
	
}
