/**
   Class:   testCoinSorter
   Date:    Sep 27 2020
 */


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.InputMismatchException;


public class CoinSorter {
	private String currency;
	private int minCoinIn = 0;
	private int maxCoinIn = 10000;
	private int totalCoinValue;
	private int excludedCoin;
	private Integer[] coinList;

	// constructor
	public CoinSorter(String currency, int minCoinIn, int maxCoinIn, Integer[] cl) {
		setCurrency(currency);
		setMinCoinIn( minCoinIn );
		setMaxCoinIn( maxCoinIn );
		coinList = cl;
		Arrays.sort(coinList, Collections.reverseOrder());
	}
	
	// dummy constructor, not sure if it's required by the assignment  
	// ( It's in the class diagram )
	public void coinSorter() { }
	
	// To show message to user. Can be overwritten by sub-classes to achieve 
	// advanced output (eg: interactive GUI)
	public void outFunc(String s) {
		System.out.println(s);
	}

	// setter for currency
	public void setCurrency(String cur) {
		outFunc("Set currency to: " + cur);
		currency = cur;
	}

	// setter for minCoinIn
	public void setMinCoinIn(int coinIn) {
		outFunc("Set minCoinIn to: " + coinIn);
		minCoinIn = coinIn;
	}

	// setter for maxCoinIn
	public void setMaxCoinIn(int coinIn) {
		outFunc("Set maxCoinIn to: " + coinIn);
		maxCoinIn = coinIn;
	}

	/* setter for setTotalCoinValue
	 * This function is not in the Assignment outline however it makes more sense to have 
	 * when this value needs to be set in sub-class
	*/
	public void setTotalCoinValue(int coinIn) {
		outFunc("Set totalCoinValue to: " + coinIn);
		totalCoinValue = coinIn;
	}

	/* setter for setExcludedCoin
	 * This function is not in the Assignment outline however it makes more sense to have 
	 * when this value needs to be set in sub-class
	*/
	public void setExcludedCoin(int coinIn) {
		outFunc("Set ExcludedCoin to: " + coinIn);
		excludedCoin = coinIn;
	}

	/* 
	 * @getter for totalCoinValue
	 * This function is not in the Assignment outline however it is required for 
	 * calling *CoinValidator() functions where the totalCoinValue has to be passed
	 * as an argument from the external 
	*/ 
	public int getTotalCoinValue() {
		return totalCoinValue;
	}

	/* 
	 * @getter for excludedCoin
	 * This function is not in the Assignment outline however it is required for 
	 * calling *CoinValidator() functions where the totalCoinValue has to be passed
	 * as an argument from the external 
	*/ 
	public int getExcludedCoin() {
		return excludedCoin;
	}

	// getter for currency
	public String getCurrency() {
		return currency;
	}

	// getter for minCoinIn
	public int getMinCoinIn() {
		return minCoinIn ;
	}

	// getter for maxCoinIn
	public int getMaxCoinIn() {
		return maxCoinIn;
	}

	/*
	 * This function is not in the Assignment outline however it makes more sense to have 
	 * when this value needs to be set in sub-class
	*/
	public Integer[] getCoinList() {
		return coinList;
	}

	// Print out coinList, as well we return the message as a string for outer caller
	public String printCoinList() {
		String msg = "The current coin denominations are in circulations: " + Arrays.toString(getCoinList());
		//System.out.println(msg);
		return msg;
	}

	// Validate instance private variable totalCoinValue
	public void validateTotalValue() {
		// set the default to be out of boundary so that it always gets checked
		int inputValue;
		outFunc("Please input the totalCoinValue: ");
		inputValue = validateIntInput();
		if ( inputValue < minCoinIn || inputValue > maxCoinIn) {
			outFunc("WARNING: totalCoinValue must be in a range: [" 
					+ minCoinIn + ", " + maxCoinIn + "]"); 
			validateTotalValue();
		} else {
			totalCoinValue = inputValue;
		}
	}

	// Validate instance private variable excludeCoin
	public void validateExcludedCoin() {
		outFunc("Coin to be excluded");
		excludedCoin = validateCoin();
	}

	// Validate coin (generic)
	public Integer validateCoin() {
		Integer inputValue;
		outFunc("Please input the coin denomination: ");
		inputValue = validateIntInput();
		if ( Arrays.asList(getCoinList()).contains(inputValue)) {
			return inputValue;
		} else {
			/* When user inputed a value not in the denomination list
			* Warn user and repeat the input prompt
			* */
			outFunc("Wrong coin specified. It's must be one of " + 
					Arrays.toString(getCoinList()));
			return validateCoin();
		}
	}


	public String coinCalculator(Integer coinType) {
		/* 
		   The original multiCoinCalculator() method requires the instance private 
		   variable totalValue which is impossible to call from outside, hence needs to
		   call the wrapper fnnction instead
		*/
		return coinCalculator(totalCoinValue, coinType);
	}


	public String coinCalculator(int totalValue, int coinType) {
		/*
		 * Calculate the coin number and reminder from the given totalCoinValue and coinType
		 */
		int n = totalValue / coinType;
		int reminder  = totalValue % coinType;
		String msg = String.format("A total of %d x %dp coins can be exchanged, with a remainder of %dp", n, coinType, reminder);
		return msg;
	}

	public String multiCoinCalculator() {
		/* 
		   The original multiCoinCalculator() method requires the instance private 
		   variable totalValue which is impossible to call from outside, hence needs to
		   call the wrapper function instead
		*/
		return multiCoinCalculator(totalCoinValue, excludedCoin);
	}

	public String multiCoinCalculator(int totalValue, Integer coinExd) {
		/*
		 * Calculate the coin number and reminder from the given totalCoinValue and coinExcluded
		 */
		Hashtable<Integer, Integer> dnTable = new Hashtable<Integer, Integer>();
		int tempTotalValue = totalValue;
		for (int coinType : getCoinList()) {
			if (coinType == coinExd) {
				// excluded coin has 0 number of coins
				dnTable.put(coinType, 0); 
				continue;
			}
			int c = tempTotalValue / coinType;
			int reminder  = tempTotalValue % coinType;
			dnTable.put(coinType, c);
			tempTotalValue = reminder;
		}
		String msg = "The coins exchanged are: ";
		for (Integer d: getCoinList()) {
			msg = msg + dnTable.get(d) + " x " + d + ", ";
		}
		msg = msg + "with a reminder of " + tempTotalValue + ".\n";
		return msg;
	}

	public String displayProgramconfigs() {
		/* 
		 * This method should return the * following as a string: 
		 * the current currency and the current minimum and maximum value accepted as input.
		 */
		String msg = "The current currency: " + getCurrency() + "\n";
		msg = msg + "The min value: " + getMinCoinIn() + "\n";
		msg = msg + "The max value: " + getMaxCoinIn() + "\n";
		return msg;
	}
	
	/*
	 * To constantly prompt user to type in an integer (repeat if not)
	 */
	public int validateIntInput() {
		int inputValue;
		Scanner sc = new Scanner(System.in);
		try { 
			inputValue = sc.nextInt();
			return inputValue;
		} catch (InputMismatchException ex) {
			outFunc("WARNING: Wrong input specified. it's must be an integer. Try again!");
			outFunc(ex.toString());
			return validateIntInput();
		}
		
	}

	/*
	 * To constantly prompt user to type in an integer (repeat if not)
	 */
	public boolean validateMinMaxRange(int min, int max) {
	    if ( min <= max ) {
	        return true;
	    } else {
	        outFunc("WARNING: setting failed - minCoinIn ( " + min + ") is larger than maxCoinIn (" + max + "). Please try again!");
	        return false;
	    }
	}
	
	// To construct prompt message for the main menu
	public static String promptMsg() {
		String  out = "";
		out +=  "***Coin Sorter - Main Menu***\n" ;
		out +=  "1 - Coin calculator\n" ;
		out +=  "2 - Multiple coin calculator\n" ;
		out +=  "3 - Print coin list\n" ;
		out +=  "4 - Set details\n" ;
		out +=  "5 - Display program configurations\n" ;
		out +=  "6 - Quit the program\n" ;
		return out;
	}

	// To construct prompt message for the sub menu for option 4
	public static String promptMsgSub4() {
		String  out = "";
	    out += "***Set Details Sub-Menu***\n";
	    out += "1 - Set currency\n";
	    out += "2 - Set minimum coin input value\n";
	    out += "3 - Set maximum coin input value\n";
	    out += "4 - Return to main menu\n";
	    return out;
	}

}