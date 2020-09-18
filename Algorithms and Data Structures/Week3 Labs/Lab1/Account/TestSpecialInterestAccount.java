
public class TestSpecialInterestAccount {
	public static void main (String[] args) {
		SpecialInterestAccount account = new SpecialInterestAccount(50000.0, 0.24, 0.15);
		account.addMonthlyInterest();
		System.out.println(account);
		account.debit(1000);
		account.credit(5000);
		account.addMonthlyInterest();
		System.out.println(account);
		account.debit(1000);
		account.debit(4000);
		account.credit(5000);
		account.addMonthlyInterest();
		System.out.println(account);
	}
}
