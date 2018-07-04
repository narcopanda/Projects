package com.in28minutes.spring.basics.springtest1.xml;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


public class XMLJdbcConnection {
	public XMLJdbcConnection() {
		System.out.println("JDBC connection");
	}
}
