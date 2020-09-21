package com.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

class InvalidDayException extends RuntimeException { //Unchecked exception
	private String message;
	public InvalidDayException() {
		this.message = "";
	}
	public InvalidDayException(String message) {
		this.message = message;
	}
	public String toString() {
		return "Invalid day exception " + this.message;
	}
	
}

class Date {
	private int day;
	private int month;
	private int year;
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public void setDay(int day)  {
		if(day<1 || day>31) {
			throw new InvalidDayException(""+day);
		}
		this.day = day;
		System.out.println("Set the day: " + day);
	}
}


class FileInputStream_2 {
	public FileInputStream_2() {
		//business logic
	}
	
	public void read(String file) throws IOException, FileNotFoundException, NullPointerException {
		boolean isCorrupt = false;
		if(isCorrupt) { //file is corrupt
			throw new IOException();
		}
		else {
			//read the file contents.
		}
	}
}

public class App 
{
	public static void printStringLength(String name) {
		
		try {
			System.out.println("String length: " + name.length()); //Unchecked exception
		}
		catch(NullPointerException e) {
			//e.printStackTrace();
			System.out.println("Please check whether your object reference is null or not");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void readFile(String fileName) {
		try {
			FileInputStream fis = new FileInputStream(fileName);
		} catch (FileNotFoundException e) { //Checked exception
			e.printStackTrace();
		}
	}
    public static void main( String[] args )
    {
    	Date dateObj = new Date(25, 7, 2020);

    	try {
    		dateObj.setDay(28);
    		dateObj.setDay(38); //InvalidDayException (custom exception)
    	}
    	catch(InvalidDayException e) {
    		System.out.println(e);
    	}
    			
    	
    	/*
    	FileInputStream_2 fis = new FileInputStream_2();
    	try {
    		fis.read("resume.txt");
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    	
    	readFile("c:/anand/resume.txt");
    	
    	String name = "Anand";
    	printStringLength(name);
    	*/
    	
    	
    	
    	/*
    	int z = 0;
    	try {
    		z = 10/0;
    		System.out.println("Try is finished");
    	}
    	catch(ArithmeticException e) {
    		e.printStackTrace();
    	}
    	*/
        //System.out.println("Z = " + z);
/*
    	try {
    		database_connection = getDBConnection();
    		//use database_connection & access database
    	}
    	finally {
   			database_connection.close();
    	}
    	
    	
    	
    	try {
    		database_connection = getDBConnection();
    		//use database_connection & access database
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	finally {
    		try {
    			database_connection.close();
    		}
    		catch(Exception e) { }
    		finally {
    			System.out.println("Closing successful");
    		}
    		//System.out.println("Closing successful");
    		
    		
    	}
  */  	
    }
}















