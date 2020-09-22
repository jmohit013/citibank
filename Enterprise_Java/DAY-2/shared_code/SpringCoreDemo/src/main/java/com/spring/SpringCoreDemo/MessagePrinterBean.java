package com.spring.SpringCoreDemo;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;

public class MessagePrinterBean  {
	private String message;

	public MessagePrinterBean() {
		super();
		System.out.println("Inside constructor");
	}

	public void initBean() {
		System.out.println("initBean()");
	}
	public void destroyBean() {
		System.out.println("destroyBean()");
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MessagePrinterBean [message=" + message + "]";
	}

	public void setBeanName(String beanName) {
		System.out.println("Bean Name: " + beanName);
		
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");
		
	}
	
}
