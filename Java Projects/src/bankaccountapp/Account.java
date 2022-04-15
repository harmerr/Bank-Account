package bankaccountapp;

public abstract class Account implements IRate {
	
	//Private since it is sensitive information
	private String name;
	private String SSN;
	private double balance;

	static int index = 10000;
	
	//Protected since they are used in the child class's code
	protected String accountNumber;
	protected double rate;
	
	//Parent constructor
	public Account(String name, String SSN, double initDeposit ) {
		this.name = name;
		this.SSN = SSN;
		balance = initDeposit;
		
		index++;
		this.accountNumber = setAccountNumber();
		
		setRate();
	}
	
	//Abstract method to set interest rate
	public abstract void setRate();
	
	//Determines each person's account number
	private String setAccountNumber() {
		String lastTwoOfSSN = SSN.substring(SSN.length() - 2, SSN.length());
		int uniqueID = index;
		int randomNumber = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoOfSSN + uniqueID + randomNumber;
	}
	
	//Calculates the accrued interest of an account and adds it to the balance
	public void compound() {
		double accruedInterest = balance * (rate/100);
		balance += accruedInterest;
		System.out.println("Accrued Interest: $" + accruedInterest);
		printBalance();
	}
	
	//Allows one to deposit money into an account
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("Depositing $" + amount);
		printBalance();
	}
	
	//Allows one to withdraw money from an account
	public void withdraw(double amount) {
		balance = balance - amount;
		System.out.println("Withdrawing $" + amount);
		printBalance();
	}
	
	//Allows one to transfer money between accounts
	public void transfer(String toWhere, double amount) {
		balance = balance - amount;
		System.out.println("Transferring $" + amount + " to " + toWhere);
		printBalance();
	}
	
	//Prints current balance of the account
	public void printBalance() {
		System.out.println("Your balance is now: $" + balance);
	}
	
	//Shows the account's information
	public void showInfo() {
		System.out.println(
				"NAME: " + name +
				"\nACCOUNT NUMBER: " + accountNumber +
				"\nBALANCE: " + balance +
				"\nRATE " + rate + "%");
	}
}
