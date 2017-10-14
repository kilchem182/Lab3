package com.kilcher.Lab3;

/* Lab3: Banking application */
// The following imports define abbreviations: you can use
// Account in place of bank.Account, StdIO in place of ucb.io.StdIO,
// FormatReader in place of ucb.io.FormatReader, etc.

import java.io.*;
import java.util.*;
import com.kilcher.Lab3.Bank;
import static java.lang.System.out; // So that 'out' means System.out

public class Banking {

  /** The main function reads and executes commands, returning
   *  results if indicated.  See the Usage function for instructions. */
	
  public static void main (String[] args) {
    int numAccounts;
    Bank bank = new Bank();
    Account[] accounts = new Account [10];
    Scanner in = new Scanner (System.in);
    numAccounts = 0;

    out.printf ("Welcome to the CSC250 bank!%nType ? for help.%n%n");

    while (true) {
      if (! in.hasNext ())
	break;
      String command = in.next ().toLowerCase ();
      
      try {
	if ("help".startsWith (command) || command.startsWith ("?")) 
	  Usage ();
	else if ("withdraw".startsWith (command)) {
	  int account = in.nextInt (), amount = in.nextInt ();
	  checkAccount (account, numAccounts);
	  out.printf ("Withdrawing %d.  Initial balance: %d", 
		      amount, accounts[account].balance ());
	  out.printf (" Ending balance: %d%n", 
		      accounts[account].withdraw (amount));
	} else if ("deposit".startsWith (command)) {
	  int account = in.nextInt (), amount = in.nextInt ();
	  checkAccount (account, numAccounts);
	  out.printf ("Depositing %d.  Initial balance: %d",
		      amount, accounts[account].balance ());
	  out.printf (" Ending balance: %d%n", 
		      accounts[account].deposit (amount));
	} else if ("balance".startsWith (command)) {
	  int account = in.nextInt ();
	  checkAccount (account, numAccounts);
	  out.printf ("Current balance: %d%n", accounts[account].balance ());
	} else if ("funds".startsWith (command)) {
	  out.printf ("Total bank funds: %d%n", bank.returnFunds());
	} else if ("open".startsWith (command)) {
	  if (numAccounts >= accounts.length) {
	    out.printf ("Too many accounts%n");
	    continue;
	  } 
	  int initialAmount = in.nextInt();
	  accounts[numAccounts] = bank.openAccount(initialAmount);
	  out.printf ("Opening new account #%d, initial balance %d%n", 
		      numAccounts, initialAmount);
	  numAccounts += 1;
	} else if ("quit".startsWith (command)) {
	  break;
	} else {
	  out.printf ("Unknown command: \"%s\"%n", command);
	}
      } catch (IllegalStateException e) {
	out.printf ("Error: %s%n", e.getMessage ());
      } catch (IllegalArgumentException e) {
	out.printf ("Error in input: %s%n", e.getMessage ());
      } catch (InputMismatchException e) {
	out.printf ("Incorrectly formed number.%n");
      } catch (NoSuchElementException e) {
	out.printf ("Input ended in the middle of a command.%n");
      }
    }

    out.printf("Thank you for banking with us!%n");
  }

  static void Usage () {
    out.printf ("Commands:%n" 
		+ "\thelp or ?      This message.%n"
		+ "\tquit           Exit application.%n"
		+ "\tbalance A      Print current balance of account #A.%n"
		+ "\tdeposit A N    Deposit amount N (an integer) in account #A%n"
		+ "\twithdraw A N   Withdraw amount N (an integer) from account #A%n"
		+ "\topen N         Open a new account with initial amount N%n"
		+ "\tfunds          Print current total bank funds%n");
  }

  /** Check that ACCOUNT is a valid account number if there are 
   *  NUM accounts.  Throw IllegalArgumentException otherwise. */
  static void checkAccount (int account, int num) {
    if (account < 0 || account >= num) {
      throw new IllegalArgumentException ("there is no account #" + account);
    }
  }

}   



