/**
   Class:   testCoinSorter
   Author:  Lizhuang Liu
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
	
	// setter for currency
	public void setCurrency(String cur) {
		System.out.println("Set currency to: " + cur);
		currency = cur;
	}

	// setter for minCoinIn
	public void setMinCoinIn(int coinIn) {
		System.out.println("Set minCoinIn to: " + coinIn);
		minCoinIn = coinIn;
	}

	// setter for maxCoinIn
	public void setMaxCoinIn(int coinIn) {
		System.out.println("Set maxCoinIn to: " + coinIn);
		maxCoinIn = coinIn;
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

	// Print out coinList, as well we return the message as a string for outer caller
	public String printCoinList() {
		String msg = "The current coin denominations are in circulations: " + Arrays.toString(coinList);
		//System.out.println(msg);
		return msg;
	}

	// Validate instance private variable totalCoinValue
	public void validateTotalValue() {
		// set the default to be out of boundary so that it always gets checked
		int inputValue;
		System.out.println("Please input the totalCoinValue: ");
		inputValue = validateIntInput();
		if ( inputValue < minCoinIn || inputValue > maxCoinIn) {
			System.out.println("WARNING: totalCoinValue must be in a range: [" 
					+ minCoinIn + ", " + maxCoinIn + "]"); 
			validateTotalValue();
		} else {
			totalCoinValue = inputValue;
		}
	}

	// Validate instance private variable excludeCoin
	public void validateExcludedCoin() {
		System.out.println("Coin to be excluded");
		excludedCoin = validateCoin();
	}

	// Validate coin (generic)
	public Integer validateCoin() {
		Integer inputValue;
		System.out.println("Please input the coin denomination: ");
		inputValue = validateIntInput();
		if ( Arrays.asList(coinList).contains(inputValue)) {
			return inputValue;
		} else {
			/* When user inputed a value not in the denomination list
			* Warn user and repeat the input prompt
			* */
			System.out.println("Wrong coin specified. It's must be one of " + 
					Arrays.toString(coinList));
			return validateCoin();
		}
	}

	public String callCoinCalculator(Integer coinType) {
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

	public String callMultiCoinCalculator() {
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
		for (int coinType : coinList) {
			if (coinType == coinExd) {
				// excluded coin has 0 number of coins
				dnTable.put(coinType, 0); 
				continue;
			}
			int c = tempTotalValue / coinType;
			int reminder  = tempTotalValue % coinType;
			//System.out.println(coinType);
			//System.out.println(c);
			//System.out.println(reminder);
			//System.out.println("===============");
			//nList.add(c);
			dnTable.put(coinType, c);
			tempTotalValue = reminder;
		}
		String msg = "The coins exchanged are: ";
		for (Integer d: coinList) {
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
			System.out.println("WARNING: Wrong input specified. it's must be an integer. Try again!");
			System.out.println(ex);
			return validateIntInput();
		}
		
	}

}