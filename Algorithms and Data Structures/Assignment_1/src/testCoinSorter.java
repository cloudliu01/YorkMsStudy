/**
   Class:   testCoinSorter
   Author:  Lizhuang Liu
   Date:    Sep 27 2020
 */


import java.util.Scanner;

public class testCoinSorter {

	public static void main(String[] args) {
		Integer coinList[] =  {100, 50, 20, 10, 5, 2};
		CoinSorter starter = new CoinSorter("Pounds sterling", 0, 9999, coinList);

		/*
		String r = starter.multiCoinCalculator(523, 10);
		System.out.print(r);
		String d = starter.displayProgramconfigs();
		System.out.print(d);
		*/
		testCoinSorter.userInput(starter);
	}
	
	public static void userInput (CoinSorter starter) {
		Integer input;
		do {
			System.out.println("***Coin Sorter - Main Menu***");
			System.out.println("1 - Coin calculator");
			System.out.println("2 - Multiple coin calculator");
			System.out.println("3 - Print coin list");
			System.out.println("4 - Set details");
			System.out.println("5 - Display program configurations");
			System.out.println("6 - Quit the program");
			input = starter.validateIntInput();
			String msg;
			Integer totalValue;
			switch (input) {
			case 1:
				starter.validateTotalValue();
				Integer vc = starter.validateCoin();
				//msg = starter.callCoinCalculator(vc);
				totalValue = starter.getTotalCoinValue();
				msg = starter.coinCalculator(totalValue, vc);
				System.out.println(msg);
				break;
			case 2:
				starter.validateTotalValue();
				starter.validateExcludedCoin();
				// The original multiCoinCalculator() method requires the instance private 
				// variable totalValue which is impossible to call from outside, hence needs to
				// call the wrapper function instead
				totalValue = starter.getTotalCoinValue();
				int excludedCoin = starter.getExcludedCoin();
				//msg = starter.callMultiCoinCalculator();
				msg = starter.multiCoinCalculator(totalValue, excludedCoin);
				System.out.println(msg);
				break;
			case 3:
				msg = starter.printCoinList();
				System.out.println(msg);
				break;
			case 4:
				testCoinSorter.userInputOption4(starter);
				break;
			case 5:
				msg = starter.displayProgramconfigs();
				System.out.println(msg);
				break;
			case 6:
				System.out.println("INFO: Quit!");
				break;
			default:
				System.out.println("WARNING: NOT Valid input: Must be 1 - 6 ");
				break;
			}
			System.out.println("");
		} while (!input.equals(6));
	}

	public static void userInputOption4(CoinSorter starter) {
		Integer input;
		do {
			System.out.println("***Set Details Sub-Menu***");
			System.out.println("1 - Set currency");
			System.out.println("2 - Set minimum coin input value");
			System.out.println("3 - Set maximum coin input value");
			System.out.println("4 - Return to main menu");
			input = starter.validateIntInput();
			switch (input) {
				case 1:
					// Input currency
					System.out.println("Please type in currency:");
					Scanner sc = new Scanner(System.in);
					String curIn = sc.next();
					starter.setCurrency(curIn);
					break;
				case 2:
					// Input minimum coin that is allowed
					System.out.println("Please type in the minimum coin value:");
					int minCoinIn = starter.validateIntInput();
					starter.setMinCoinIn(minCoinIn);
					break;
				case 3:
					// Ask for maximum coin that is allowed
					System.out.println("Please type in the maximum coin value:");
					int maxCoinIn = starter.validateIntInput();
					starter.setMaxCoinIn(maxCoinIn);
					break;
				case 4:
					// GOTO upper level ( will break the outer while loop
					//testCoinSorter.userInput(starter);
					break;
				default:
					// Repeat the option list as the outer while loop will continue
					System.out.println("NOT Valid input");
					break;
			}
			System.out.println("");
		} while (!input.equals(4));
	}

}
