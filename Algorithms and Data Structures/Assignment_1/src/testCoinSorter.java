/**
   Class:   testCoinSorter
   Author:  
   Date:    Sep 27 2020
 */


import java.util.ArrayList;
import java.util.Scanner;

public class testCoinSorter {

	public static void main(String[] args) {
		Integer coinList[] =  {100, 50, 20, 10, 5, 2};
		CoinSorter starter = new CoinSorter("Pounds sterling", 0, 9999, coinList);

		testCoinSorter.userInput(starter);
	}
	
	public static void userInput (CoinSorter starter) {
		Integer input;
		do {
			// Print out prompt
			String info = CoinSorter.promptMsg();
			System.out.println(info);
			
			// Get & Validate input
			input = starter.validateIntInput();

			// Initialise variables going to be used
			String msg;
			Integer totalValue;

			switch (input) {

			//1 - Coin Calculator
			case 1:
				starter.validateTotalValue();
				// validaeCoin() is not in the Assignment outline but seems better to have here
				Integer vc = starter.validateCoin();
				totalValue = starter.getTotalCoinValue();
				msg = starter.coinCalculator(totalValue, vc);
				starter.outFunc(msg);
				break;

			//2 - Multiple coin calculator
			case 2:
				starter.validateTotalValue();
				starter.validateExcludedCoin();

				// Need to use below 2 customized gettattr fnctions to get the necessary parameters 
				// which will be used as arguments in multiCoinCalculator()
				totalValue = starter.getTotalCoinValue();
				int excludedCoin = starter.getExcludedCoin();

				msg = starter.multiCoinCalculator(totalValue, excludedCoin);
				starter.outFunc(msg);
				break;

			//3 - Print coin list
			case 3:
				msg = starter.printCoinList();
				starter.outFunc(msg);
				break;
				
			//4 - Set details
			case 4:
				testCoinSorter.userInputOption4(starter);
				break;
				
			//5 - Display program configurations
			case 5:
				msg = starter.displayProgramconfigs();
				System.out.println(msg);
				break;
				
			//6 - Quit the program
			case 6:
				starter.outFunc("INFO: Quit!");
				break;
				
			//Otherwise - Warn user 
			default:
				starter.outFunc("WARNING: NOT Valid input: Must be 1 - 6 ");
				break;
			}
			System.out.println("");
		} while (!input.equals(6));
	}

	public static void userInputOption4(CoinSorter starter) {
		Integer input;
		do {
		    String msg = starter.promptMsgSub4();
			starter.outFunc(msg);
			input = starter.validateIntInput();

			switch (input) {

				// Input currency
				case 1:
					starter.outFunc("Please type in currency:");
					Scanner sc = new Scanner(System.in);
					String curIn = sc.next();
					starter.setCurrency(curIn);
					break;
					
				// Input minimum coin that is allowed
				case 2:
					starter.outFunc("Please type in the minimum coin value:");
					int minCoinIn = starter.validateIntInput();
					// only set when the range is valid
					if (starter.validateMinMaxRange(minCoinIn, starter.getMaxCoinIn())) {
					    starter.setMinCoinIn(minCoinIn);
					}
					break;
					
				// Ask for maximum coin that is allowed
				case 3:
					starter.outFunc("Please type in the maximum coin value:");
					int maxCoinIn = starter.validateIntInput();
					// only set when the range is valid
					if (starter.validateMinMaxRange(starter.getMinCoinIn(), maxCoinIn)) {
					    starter.setMaxCoinIn(maxCoinIn);
					}
					break;
					
				// GOTO upper level ( will break the outer while loop
				//testCoinSorter.userInput(starter);
				case 4:
					break;
					
				// Otherwise - Repeat the option list as the outer while loop will continue
				default:
					starter.outFunc("NOT Valid input");
					break;
			}
			starter.outFunc("");
		} while (!input.equals(4));
	}

}
