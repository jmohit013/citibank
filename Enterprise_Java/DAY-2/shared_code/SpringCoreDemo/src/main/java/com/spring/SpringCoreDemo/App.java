package com.spring.SpringCoreDemo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
AbstractApplicationContext iocContainer = 
		new ClassPathXmlApplicationContext("Beans_simple.xml"); 
		//ClassPathXmlApplicationContext is IoC container

MessagePrinterBean bean = (MessagePrinterBean)iocContainer.getBean("messagePrinter");
System.out.println("Message: " + bean.getMessage());

bean = (MessagePrinterBean)iocContainer.getBean("messagePrinter");
System.out.println("Message 2: " + bean.getMessage());

    }
}
