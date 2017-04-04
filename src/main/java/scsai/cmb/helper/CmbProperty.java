package scsai.cmb.helper;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class CmbProperty extends PropertyPlaceholderConfigurer {
	private static final Logger logger = Logger.getLogger(CmbProperty.class);
	private static final String regex="^\\$\\{.+\\}$";
	
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		String returnPropertyValue="";
		if(propertyValue.matches(regex)){
			try {
				returnPropertyValue = SecurityAES.decrypt(propertyValue.substring(2,propertyValue.length()-1));
			} catch (Exception e) {
				logger.error("initial properties "+propertyName+" error",e);
			}
		}else{
			returnPropertyValue=propertyValue;
		}
		
		return returnPropertyValue;
	}
	
}
