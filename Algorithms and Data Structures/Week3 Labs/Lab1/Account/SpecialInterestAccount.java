
public class SpecialInterestAccount extends InterestAccount {
	double pRate;
	int nTransactions;
	
	/*
	 * Used methods that are inherited from its parents
	 * getBalance()
	 * setBalance()
	 * getMonthlyInterestRate()
	 */
	public SpecialInterestAccount(double initBalance, double pRate, double nRate) {
		super(initBalance, nRate);
		setPRate(pRate);
		nTransactions = 0;
	}
	
	public void setPRate (double r) {
		pRate = r;
	}

	public double getPRate () {
		return pRate;
	}
	
	public void credit (double c) {
		nTransactions += 1;
        setBalance(getBalance() + c);
	}

	public boolean debit (double d) {
		nTransactions += 1;
		//return debit(c);
        if    ((getBalance() - d) < 0)
              return false;
        else  
        	setBalance(getBalance() - d);
        	return true;
	}
	
	public String toString () {
		String msg = "Balance : " + getBalance() + "\n";
        if (nTransactions < 4) {
        	msg = msg + "premium interest : " + getPRate() + "\n";
        } else {
        	msg = msg + "regular interest : " + getMonthlyInterestRate() + "\n";
        }
        return msg;
	}

	public double calMonthlyInterest() {
		double b = getBalance();
        if (nTransactions < 4) {
        	return (b * getPRate());
        } else {
        	return (b * getMonthlyInterestRate());
        }
	}
}
