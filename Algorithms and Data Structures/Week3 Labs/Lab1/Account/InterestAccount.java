
public class InterestAccount extends Account {
	
	private double monthlyInterestRate;

	public InterestAccount(double balance, double mir) {
		super(balance);
		// TODO Auto-generated constructor stub
		monthlyInterestRate = mir;
	}
	
	public void setMonthlyInterestRate(double mir) {
		monthlyInterestRate = mir;
	}

	public double getMonthlyInterestRate() {
		return monthlyInterestRate ;
	}

	public void addMonthlyInterest() {
		double interest = calMonthlyInterest();
		credit(interest);
	}

	public double calMonthlyInterest() {
		double b = getBalance();
		return (b * monthlyInterestRate);
	}
	
}
