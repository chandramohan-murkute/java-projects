package com.mo.billsys.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource({ Constants.PROPERTIES })
public class PropertyUtil {

	public static Environment	environment;

	@Autowired
	public PropertyUtil(final Environment env) {
		environment = env;
	}

	public static String getProperty(String key) {
		return environment.getProperty(key);
	}
}
