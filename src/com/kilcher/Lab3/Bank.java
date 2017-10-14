package com.kilcher.Lab3;

import com.kilcher.Lab3.Account;

/** Represents a Bank: a repository of funds. */
public class Bank {
	
	private int funds = 0;
	
	//Deposits funds into bank.
	//User cannot deposit negative funds
	void depositFunds(int fundsAdded) {
		if(fundsAdded < 0) {
			throw new IllegalStateException
				("Cannot deposit negative funds");
		}
		else {
			this.funds += fundsAdded;
		}
	}
	
	void withdrawFunds(int fundsTaken) {
		if(fundsTaken < 0) {
			throw new IllegalStateException
				("Cannot withdraw negative funds");
		}
		else if(this.funds < fundsTaken) {
			throw new IllegalStateException
				("Cannot withdraw more than current funds");
		}
		else {
			this.funds -= fundsTaken;
		}
	}
	
	public int returnFunds() {
		return funds;
}
	
	public Account openAccount(int initialAmount) {
		this.funds += initialAmount; 
		return new Account(initialAmount, this);		
	}
}
