package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
	
	public static void main(String[] args) {
		
		//Linked list of accounts imported from CSV files
		List<Account> accounts = new LinkedList<Account>();
		
		//File reading from CSV class method
		String file = "C:\\Users\\RaymondHarmer\\Downloads\\NewBankAccounts.csv";
		
		List<String[]> newAccHolders = utilities.CSV.read(file);
		
		for(String[] accountHolder : newAccHolders) {
			String name = accountHolder[0];
			String SSN = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);
			
			if(accountType.equals("Savings")) {
				accounts.add(new Savings(name, SSN, initDeposit));
			}
			else if(accountType.equals("Checking")) {
				accounts.add(new Checking(name, SSN, initDeposit));
			}
			else {
				System.out.println("ERROR READING ACCOUNT TYPE");
			}
		}
		
		//Loops through the accounts LinkedList and prints the account info
		for(Account acc : accounts) {
			System.out.println("\n**************");
			acc.showInfo();
		}
	}
}
