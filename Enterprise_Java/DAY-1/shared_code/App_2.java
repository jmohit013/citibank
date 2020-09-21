package com.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class MyResource implements AutoCloseable {
	public void setUpInitilizeResource() { 
		System.out.println("Inside setUpInitilizeResource()");
	}
	public void useResource() {
		System.out.println("Inside useResource()");
		//business logic
	}
	public void close() throws Exception {
		System.out.println("Resource closed");
	}
}

class MyResource_2 implements AutoCloseable {
	public void setUpInitilizeResource() { 
		System.out.println("Inside setUpInitilizeResource2()");
	}
	public void useResource() throws Exception {
		System.out.println("Inside useResource2()");
		throw new Exception("Resource usage exception");
		//business logic
	}
	public void close() throws Exception {
		System.out.println("Trying to close the resource2");
		throw new Exception("Closing error"); //Suppressed exception
		//System.out.println("Resource2 closed");
	}
}

public class App_2 {

	public static void main(String[] args) {

		try(MyResource_2 resource2 = new MyResource_2();) { //try with resources
			resource2.setUpInitilizeResource();
			resource2.useResource();
		}
		catch(Exception e) {
			//e.printStackTrace();
			System.out.println(e);
			Throwable syppressedExceptions[] = e.getSuppressed();
			for(Throwable syppressedException: syppressedExceptions) {
				System.out.println("SUPPRESSED: " + syppressedException);
			}
		}

		try {
			int z = 10/5;
			String name = null;
			System.out.println(name.length());
		}
		catch(ArithmeticException | NullPointerException e) {
			e.printStackTrace();
		}
		
		/*
		try {
			int z = 10/5;
			String name = null;
			System.out.println(name.length());
		}
		catch(ArithmeticException e) {
			e.printStackTrace();
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
		*/
		
		/*
		try (FileInputStream fis = new FileInputStream("c:/anand/resume.txt");){
			fis.read();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		*/
		/*
		MyResource resource = new MyResource();
		resource.setUpInitilizeResource();
		try {
			resource.useResource();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				resource.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		*/
	}

}
