package com.bank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankOperations {

	static Logger logger = LogManager.getLogger(BankOperations.class.getName());
	
	public static Account createAccount(int accno, String name, double balance) {
		logger.trace("accno: " + accno);
		
		logger.info("New Account created successfully!!");
		return new Account(accno, name, balance);
	}
	
	public static boolean transferFunds(Account sourceAccount, Account destinationAccount, double transferAmount) {
		if(sourceAccount.getBalance() < transferAmount)
			return false;
		sourceAccount.setBalance(sourceAccount.getBalance() - transferAmount);
		destinationAccount.setBalance(destinationAccount.getBalance() + transferAmount);
		return true;
	}
	
	public static double deposit(Account account, double amount) {
		account.setBalance(account.getBalance() + amount);
		return account.getBalance();
	}

	public static double withdraw(Account account, double amount) {
		if(account.getBalance() < amount)
			return -1;
		account.setBalance(account.getBalance() - amount);
		return account.getBalance();
	}
}
