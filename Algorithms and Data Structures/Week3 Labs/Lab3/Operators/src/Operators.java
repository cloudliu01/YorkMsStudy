import java.io.*;
import java.util.*;

public class Operators {

	public Operators() {
		// TODO Auto-generated constructor stub
	}
	
	public static int add (int a, int b) {
		return a + b;
	}

	public static int substract (int a, int b) {
		return a - b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner sc = new Scanner(System.in);
		String method = args[0];
		int retVal;
		try {
			int a = Integer.parseInt(args[1]);
			int b = Integer.parseInt(args[2]);
			if (method.equals("add")) {
					retVal = add(a, b);
					System.out.println("Result => " + retVal);
			} else if (method.equals("substract")) {
					retVal = substract(a, b);
					System.out.println("Result => " + retVal);
			} else {
				System.out.printf("Unknown operator \"%s\". only \"add\" and \"substract\" are supported", method);
			}
		} catch (NumberFormatException ex) {
			System.out.println("error cannot convert 7 and 9.9 to integers");
			System.out.println(ex);
		}
	}

}
