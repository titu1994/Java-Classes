package asignment5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

abstract class Account {
	
	protected String cust_name;
	protected int cust_id;
	protected String cust_type;
	protected double cust_balance;
	protected boolean isCurrentType;
	protected boolean isSavingsType;
	
	public abstract void setType(String type);
	
}

class Current extends Account implements Comparable<Account>{

	private static final double SERVICE_CHARGE = 1000;
	private static final double OVER_DRAWEN_LIMIT = 6000;
	
	@Override
	public void setType(String type) {
		// TODO Auto-generated method stub
		
		cust_type = type;
		isCurrentType = true;
	}
	
	public Current(String name, int id, String type, double balance) {
		// TODO Auto-generated constructor stub
		
		cust_name = name;
		cust_id = id;
		setType(type);
		cust_balance = balance;
	}
	
	public void checkbookDeposit(double amt){
		checkbook(amt);
	}
	
	private void checkbook(double amt){
		if(checkCustBalance(amt)){
			cust_balance += amt;
			System.out.println("Balance is : "+cust_balance);
		}
		else{
			
			cust_balance -= SERVICE_CHARGE ;
			cust_balance += amt;
			
			System.out.println("Service charge of "+SERVICE_CHARGE+" required due to balance being insufficient.");
			
			if(cust_balance < 0){
				System.out.println("Current Account over withdrawn. Limit of "+OVER_DRAWEN_LIMIT+" is allowed.");
				
				if(isOverdrawen(cust_balance)){
					System.out.println("Exceeded Over Drawen Limit");
				}
				
			}
			
			System.out.println("Balance is : "+cust_balance);
		}
	}
	
	private boolean isOverdrawen(double bal){
		if(cust_balance >= OVER_DRAWEN_LIMIT)
			return true;
		else 
			return false;
	}
	
	private boolean checkCustBalance(double amt){
		return (amt >= 15000);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name : "+cust_name + " ID : " + cust_id +" Type : "+cust_type + " Balance : "+cust_balance;
	}

	@Override
	public int compareTo(Account o) {
		// TODO Auto-generated method stub
		return (int) (o.cust_balance - this.cust_balance);
	}
	
}

class Savings extends Account implements Comparable<Account>{
	
	private static final double THRESHOLD1 = 20000;
	private static final double THRESHOLD2 = 50000;
	private static final double THRESHOLD3 = 100000;
	
	private double interestRate = 8.5;
	
	private double currentLoanPaymentOutstanding = 0;

	@Override
	public void setType(String type) {
		// TODO Auto-generated method stub
		
		cust_type = type;
		isSavingsType = true;
	}
	
	public Savings(String name, int id, String type, double balance) {
		// TODO Auto-generated constructor stub
		
		cust_name = name;
		cust_id = id;
		setType(type);
		cust_balance = balance;
		
	}
	
	public double computeInterest(){
		return cust_balance*(interestRate/100);
	}
	
	public boolean demandLoan(double amt){
		
		int TLimit = checkThresholdLimit(amt);
		
		if(TLimit == 1){
			interestRate -= 0.5;
			amt += 20000;
			currentLoanPaymentOutstanding += 20000 + computeInterest();
			
			return true;
		}
		else if(TLimit == 2){
			interestRate -= 1.0;
			amt += 35000;
			currentLoanPaymentOutstanding += 35000 + computeInterest();
			
			return true;
		}
		else if(TLimit == 3){
			interestRate -= 2;
			amt += 65000;
			currentLoanPaymentOutstanding += 65000 + computeInterest();
			
			return true;
		}
		else if(TLimit == 4){
			interestRate -= 3.5;
			amt += 100000;
			currentLoanPaymentOutstanding += 100000 + computeInterest();
			
			return true;
		}
		else 
			return false;
		
	}
	
	public boolean paybackLoan(double amt){
		
		if(checkLoanOutstanding()){
			
			if(cust_balance >= amt && amt >= currentLoanPaymentOutstanding){
				cust_balance -= currentLoanPaymentOutstanding;
				currentLoanPaymentOutstanding = 0;
			}
			else{
				cust_balance -= amt;
				currentLoanPaymentOutstanding -= amt;
				
				if(cust_balance < 0){
					cust_balance = 0;
				}
			}
			
			return true;
			
		}
		else{
			return false;
		}
		
	}
	
	private boolean checkLoanOutstanding(){
		return currentLoanPaymentOutstanding != 0;
	}
	
	private int checkThresholdLimit(double amt){

		if(amt > 0 && amt <= THRESHOLD1){
			return 1;
		}
		else if(amt > THRESHOLD1 && amt <= THRESHOLD2){
			return 2;
		}
		else if(amt > THRESHOLD2 && amt <= THRESHOLD3){
			return 3;
		}
		else 
			return 4;
		
	}
	
	public boolean withdraw(double amt){
		if(checkBalance(amt)){
			
			cust_balance-=amt;
			return true;
		}
		
		return false;
	}
	
	private boolean checkBalance(double amt){
		return cust_balance > amt;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name : "+cust_name + " ID : " + cust_id +" Type : "+cust_type + " Balance : "+cust_balance ;
	}

	@Override
	public int compareTo(Account o) {
		// TODO Auto-generated method stub
		return (int) (o.cust_balance - this.cust_balance);
	}

}


class BankManupulationClass {
	
	private static final BufferedReader bb = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException, NumberFormatException{
		// TODO Auto-generated method stub

		String name = "", type = "";
		int id = 0, choice = -1;
		double balance = 0;

		HashMap<Integer, Account> t = new HashMap<Integer, Account>();

		System.out.println("Give choice : \n1 -> Adding Customer \n2 -> Searching a Customer \n3 -> Displaying all Customers \n4 -> Removing a Customer \n5 -> Depositing Amount \n6 -> Withdrawing Amount\n7 -> Compute Interest \n8 -> Demand Loan\n 9 -> Payback Loan");

		do{
			System.out.print("Enter a choice : ");
			choice = Integer.parseInt(bb.readLine());

			switch(choice){

			case 1:{
				System.out.println("Enter the name, id, type (Savings or Current) and balance");

				name = bb.readLine();
				id = Integer.parseInt(bb.readLine());
				type = bb.readLine();
				balance = Double.parseDouble(bb.readLine());

				if(type.contains("S")|| type.contains("s")  || type.equalsIgnoreCase("Savings")){
					Savings s = new Savings(name, id, type, balance);

					t.put(id, s);
				}
				else if(type.contains("C") || type.contains("c") || type.equalsIgnoreCase("Current")){
					Current c = new Current(name, id, type, balance);
					t.put(id, c);
				}
				else{
					System.out.println("Wrong type : S or C");
				}

				System.out.println("Account added");

				break;
			}

			case 2:{

				System.out.println("Enter the id : ");
				int ID = Integer.parseInt(bb.readLine());

				Account a = t.get(ID);

				if(a != null){
					System.out.println(a);
				}
				else{
					System.out.println("Wrong ID");
				}

				break;
			}

			case 3:{
				Account temp[] = new Account[t.size()];

				int j = 0;

				for(Map.Entry<Integer, Account> ele : t.entrySet()){
					temp[j++] = ele.getValue();
				}

				Arrays.sort(temp);

				for(int i = 0; i < temp.length; i++){
					System.out.println(temp[i]);
				}

				break;
			}

			case 4:{

				System.out.println("Enter the id : ");
				int ID = Integer.parseInt(bb.readLine());

				if(t.remove(ID) != null)
					System.out.println("Successful");
				else
					System.out.println("Does not exist");

				break;
			}

			case 5:{

				System.out.println("Enter the id : ");
				int ID = Integer.parseInt(bb.readLine());

				Account a = t.get(ID);

				if(a != null){
					try{
						Current c = (Current) a;

						if(c.isCurrentType){
							System.out.println("Enter the ammount to add : ");
							double amt = Double.parseDouble(bb.readLine());
							c.checkbookDeposit(amt);
						}
						else{
							System.out.println("Not a Current type account");
						}
					}catch(ClassCastException e){
						System.out.println("Not a Current type account");
					}
				}


				break;
			}

			case 6:{

				System.out.println("Enter the id : ");
				int ID = Integer.parseInt(bb.readLine());

				Account a = t.get(ID);

				if(a != null){

					try{
						Savings sa = (Savings) a;

						if(sa.isSavingsType)	{
							System.out.println("Enter the ammount to withdraw : ");
							double amt = Double.parseDouble(bb.readLine());

							if(sa.withdraw(amt))
								System.out.println("Balance is : "+sa.cust_balance);
							else
								System.out.println("Insufficiant funds ");
						}

					}catch(ClassCastException e){
						System.out.println("This account is not a Savings type account");
					}
				}
				else{
					System.out.println("No Account exists with that id");
				}

				break;
			}

			case 7:{

				System.out.println("Enter the id : ");
				int ID = Integer.parseInt(bb.readLine());

				Account a = t.get(ID);

				if(a != null){

					try{

						Savings c = (Savings) a;

						double interest = c.computeInterest();

						System.out.println("Interest is : "+interest);
						System.out.println("Balance is : "+(c.cust_balance+interest));

					}catch(ClassCastException e){
						System.out.println("The account type is a Current account. Interest is not available");
					}

				}
				else{
					System.out.println("No Account exists with that id");
				}

				break;
			}
			case 8:{

				System.out.println("Enter the id : ");
				int ID = Integer.parseInt(bb.readLine());

				Account a = t.get(ID);

				if(a != null){

					try{
						Savings sa = (Savings) a;

						if(sa.isSavingsType)	{
							System.out.println("Enter the ammount to demand a loan : ");
							double amt = Double.parseDouble(bb.readLine());

							if(sa.demandLoan(amt))
								System.out.println("Balance is : "+sa.cust_balance);
							else
								System.out.println("Insufficiant funds ");
						}

					}catch(ClassCastException e){
						System.out.println("This account is not a Savings type account");
					}
				}
				else{
					System.out.println("No Account exists with that id");
				}

				break;
			}
			case 9:{

				System.out.println("Enter the id : ");
				int ID = Integer.parseInt(bb.readLine());

				Account a = t.get(ID);

				if(a != null){

					try{
						Savings sa = (Savings) a;

						if(sa.isSavingsType)	{
							System.out.println("Enter the ammount to payback a loan : ");
							double amt = Double.parseDouble(bb.readLine());

							if(sa.paybackLoan(amt))
								System.out.println("Balance is : "+sa.cust_balance);
							else
								System.out.println("No outstanding loan");
						}

					}catch(ClassCastException e){
						System.out.println("This account is not a Savings type account");
					}
				}
				else{
					System.out.println("No Account exists with that id");
				}

				break;
			}

			default:{
				System.out.println("Exiting");
				choice = -1;
			}
			}

		}while(choice != -1);

	}

}
