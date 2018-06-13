package com.in28minutes.spring.basics.springtest1.xml;

//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class XMLPerson {
	
	XMLJdbcConnection xmljdbcConnection;

	public XMLJdbcConnection getXMLJdbcConnection() {
		return xmljdbcConnection;
	}

	public void setXMLJdbcConnection(XMLJdbcConnection jdbcConnection) {
		this.xmljdbcConnection = jdbcConnection;
	}

	
}
