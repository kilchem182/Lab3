package com.kilcher.Lab3;

/** A bank account.  At any given time, an account holds a 
 *  non-negative balance.  */
public class Account {
  /** Funds in this account */
  private int balance;
  
  private Bank bank;

  /** A new account, initially containing BALANCE0 */
  Account (int balance0, Bank bank0) {
    balance = balance0;
    bank = bank0;
  }

  /** Deposit AMOUNT in this Account.  AMOUNT must be
   *  non-negative. */
  public int deposit (int amount) { 
    if (amount < 0) {
    	throw new IllegalStateException
    		("Cannot deposit negative funds");
    }
    else {
    	balance += amount;
    	bank.depositFunds(amount);
    	return balance;
    }
  }

  /** Withdraw AMOUNT from this Account.  AMOUNT must be
   *  non-negative, and must not exceed available funds. */
  public int withdraw (int amount) {
	  
    if (balance < amount) {
      throw new IllegalStateException 
          ("Insufficient funds");
    }
    else if (amount < 0) {
    	throw new IllegalStateException
    		("Cannot withdraw negative funds");
    }
    else {
      balance -= amount;
      bank.withdrawFunds(amount); 
      return balance;
     }
  }

  /** The current balance. */
  public int balance () { 
    return balance; 
  }

}
