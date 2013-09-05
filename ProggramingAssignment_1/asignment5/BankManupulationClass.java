package asignment5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;



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
	
	public void checkbook(double amt){
		if(cust_balance >= 15000){
			cust_balance += amt;
			System.out.println("Balance is : "+cust_balance);
		}
		else{
			
			cust_balance -= SERVICE_CHARGE ;
			cust_balance += amt;
			
			System.out.println("Service charge of "+SERVICE_CHARGE+" required due to balance being insufficient.");
			
			if(cust_balance < 0){
				cust_balance = 0;
			}
			
			System.out.println("Balance is : "+cust_balance);
		}
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
		return cust_balance*(8.5/100);
	}
	
	public boolean withdraw(double amt){
		if(cust_balance > amt){
			
			cust_balance-=amt;
			
			return true;
			
		}
		
		return false;
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
		
		Hashtable<Integer,Account> t = new Hashtable<Integer, Account>();
		
		do{
			
			System.out.println("Give choice : \n1 -> Adding Customer \n2 -> Searching a Customer \n3 -> Displaying all Customers \n4 -> Removing a Customer \n5 -> Depositing Amount \n6 -> Withdrawing Amount\n7 -> Compute Interest \n8 -> Exit");
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
				Enumeration<Account> e = t.elements();
				
				int j = 0;
				while(e.hasMoreElements()){
					temp[j] = e.nextElement();
					j++;
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
					System.out.println("Succeddful");
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
							c.checkbook(amt);
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
			
			default:{
				System.out.println("Exiting");
				choice = -1;
			}
			}
			
		}while(choice != -1);

	}

}
