package com.coogasales.core.automation;

/**
 * Utility functions for manipulating classes and resources.
 * 
 * @author Marco Meschieri - coogasales
 * @since 7.5.1
 */
public class ClassTool {
	public Object newInstance(String classname) throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		try {
			return Class.forName(classname).newInstance();
		} catch (Throwable t) {
			// The classname as is was not found, so try to prefix with our root
			// package
			return Class.forName("com.coogasales." + classname).newInstance();
		}
	}
}