package asignment2;

public class Sales {

	
	private double sales;
	private double commission;

	public double getSales() {
		return sales;
	}
	
	public double getCommission() {
		return commission;
	}

	private void setCommission(double commission) {
		this.commission = commission;
	}

	public Sales(double sales){
		this.sales = sales;
	}
	
	public void commissionCalculate(){
		
		if( getSales() < 500){
			setCommission(getSales() * 2/100);
		}
		else if(getSales() >= 500 && getSales() <5000){
			setCommission(getSales() * 5/100);
		}
		else
			setCommission(getSales() * 8/100);
	}

	public String toString() {
		
		return "Sale of " + getSales() + " entitles commossion of : " + getCommission() + "\nThe total is : " + (getSales() + getCommission());
	}
	
	
	
}
