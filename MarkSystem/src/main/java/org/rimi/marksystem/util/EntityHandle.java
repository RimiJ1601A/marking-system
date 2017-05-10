package org.rimi.marksystem.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class EntityHandle<T> {
	
	Logger logger = Logger.getLogger(EntityHandle.class);

	/**
	 * 
	 * @param entities
	 * @param propertyNames
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<List<String>> convertEntityToList(List<T> entities,List<String> propertyNames) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		
		logger.info(propertyNames);
		
		List<List<String>> listResult = new ArrayList<>();
		for (int i = 0; i < entities.size(); i++) {
			T t = entities.get(i);

			List<String> properties = new ArrayList<>();
			for(String pro : propertyNames){
				properties.add(getPropertyByName(pro,t));
			}
			listResult.add(properties);
		}
		return listResult;
	}
	
	public String getPropertyByName(String propertyName,T t) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		Class clazz = t.getClass();
		String methodName = "get"+propertyName.substring(0, 1).toUpperCase()+propertyName.substring(1);
		Object objT = clazz.newInstance();
		Method meth = clazz.getMethod(methodName);
		Object reulstObj = meth.invoke(t);
		
	 	return reulstObj == null ? "" : reulstObj.toString(); 
	}
	
}
