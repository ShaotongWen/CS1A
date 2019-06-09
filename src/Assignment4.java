
/**
 * @author Shaotong Wen
 * @class  W19 CS F001A 06W Obj-Oriented Prog Method Java
 * @instructor Dave Harden
 * @nameOffile Assignment4.java
 * @date Feb6,2019
 * the system of purchase transactions
 */

import java.util.Scanner;

public class Assignment4 
{
	static final String Choice_1_NAME = "P (process Purchase)";
	static final String Choice_2_NAME = "S (Shut down)";
	static final String INDENT = "   ";
	static final String SEPARATOR = "\n";
	static final int STAMPS_NUMBER_QUALIFIES = 7;

	public static void main(String[] args) 
	{
		String userInputStr;
		int userInputInt;
		Scanner inputStream = new Scanner(System.in);
		boolean status;
		int stamps;
		// print menu
		System.out.println("Menu:");
		System.out.println(INDENT + Choice_1_NAME);
		System.out.println(INDENT + Choice_2_NAME + SEPARATOR);
		System.out.print(INDENT + "Your Choice:");
		userInputStr = inputStream.nextLine();
		stamps = 0; // Initialize the number of stamps
		while (1 > 0) 
		{
			if (userInputStr.substring(0, 1).equals("i")) 
			{
				System.out.println("Menu:");
				System.out.println(INDENT + Choice_1_NAME);
				System.out.println(INDENT + Choice_2_NAME + SEPARATOR);
				System.out.print(INDENT + "Your Choice:");
				userInputStr = inputStream.nextLine();
			}
			status = true;
			if (userInputStr.substring(0, 1).equals("p") || userInputStr.substring(0, 1).equals("P") && status) 
			{

				System.out.print(SEPARATOR + INDENT + "How many yogurts would you like to buy ? ");
				userInputStr = inputStream.nextLine();
				userInputInt = Integer.parseInt(userInputStr);
				stamps += userInputInt;
				System.out.println(INDENT + "You just earned " + userInputInt + " stamps and have a total of " + stamps
						+ " to use.");
				System.out.println(SEPARATOR + "Menu:");
				System.out.println(INDENT + Choice_1_NAME);
				System.out.println(INDENT + Choice_2_NAME + SEPARATOR);
				System.out.print(INDENT + "Your Choice:");
				userInputStr = inputStream.nextLine();
				while (stamps > 7 && status && userInputStr.substring(0, 1).equals("p")
						|| userInputStr.substring(0, 1).equals("P")) 
				{
					System.out.print(SEPARATOR + INDENT
							+ "You qualify for a free yogurt. Would you like to use your credits? (Y or N) ");
					userInputStr = inputStream.nextLine();
					if (userInputStr.substring(0, 1).equals("y") || userInputStr.substring(0, 1).equals("Y")) 
					{
						stamps -= 7;
						System.out.print(INDENT + "You have just used 7 credits and have " + stamps + " left.");
						System.out.print(SEPARATOR + INDENT + "Enjoy your free yogurt.");
						status = false;
						userInputStr = "p";
					} 
					else if (userInputStr.substring(0, 1).equals("n") || userInputStr.substring(0, 1).equals("N")) 
					{
						status = false;
						userInputStr = "p";
					} 
					else 
					{
						System.out.println(SEPARATOR + INDENT + "*** Invalid response ***");
						userInputStr = "i";
						status = false;
					}

				}
			} 
			else if (userInputStr.substring(0, 1).equals("s") || userInputStr.substring(0, 1).equals("S")) 
			{
				System.exit(0);
			} 
			else 
			{
				System.out.println(INDENT + "*** Use P or S, please. ***");
				userInputStr = "i";
			}
		}
		
	}
	
}

/*
 * ---------------- sample run1 --------------------------------
 * 
 * Menu: P (process Purchase) S (Shut down)
 * 
 * Your Choice:dddd Use P or S, please. *** Menu: P (process Purchase) S (Shut
 * down)
 * 
 * Your Choice:push
 * 
 * How many yogurts would you like to buy ? 18 You just earned 18 stamps and
 * have a total of 18 to use.
 * 
 * Menu: P (process Purchase) S (Shut down)
 * 
 * Your Choice:p2
 * 
 * You qualify for a free yogurt. Would you like to use your credits? (Y or N) n
 * 
 * How many yogurts would you like to buy ? 23 You just earned 23 stamps and
 * have a total of 41 to use.
 * 
 * Menu: P (process Purchase) S (Shut down)
 * 
 * Your Choice:p
 * 
 * You qualify for a free yogurt. Would you like to use your credits? (Y or N) k
 *** 
 * Invalid response *** Menu: P (process Purchase) S (Shut down)
 * 
 * Your Choice:2 Use P or S, please. *** Menu: P (process Purchase) S (Shut
 * down)
 * 
 * Your Choice:p
 * 
 * How many yogurts would you like to buy ? 2 You just earned 2 stamps and have
 * a total of 43 to use.
 * 
 * Menu: P (process Purchase) S (Shut down)
 * 
 * Your Choice:process
 * 
 * You qualify for a free yogurt. Would you like to use your credits? (Y or N) Y
 * You have just used 7 credits and have 36 left. Enjoy your free yogurt. How
 * many yogurts would you like to buy ? 0 You just earned 0 stamps and have a
 * total of 36 to use.
 * 
 * Menu: P (process Purchase) S (Shut down)
 * 
 * Your Choice:s
 * 
 * -------------------------------------------------------------
 */

/*
 * ---------------- sample run2 --------------------------------
 * 
 * Menu: P (process Purchase) S (Shut down)
 * 
 * Your Choice:p
 * 
 * How many yogurts would you like to buy ? 20 You just earned 20 stamps and
 * have a total of 20 to use.
 * 
 * Menu: P (process Purchase) S (Shut down)
 * 
 * Your Choice:dddd Use P or S, please. *** Menu: P (process Purchase) S (Shut
 * down)
 * 
 * Your Choice:push
 * 
 * How many yogurts would you like to buy ? 30 You just earned 30 stamps and
 * have a total of 50 to use.
 * 
 * Menu: P (process Purchase) S (Shut down)
 * 
 * Your Choice:p
 * 
 * You qualify for a free yogurt. Would you like to use your credits? (Y or N) n
 * 
 * How many yogurts would you like to buy ? 0 You just earned 0 stamps and have
 * a total of 50 to use.
 * 
 * Menu: P (process Purchase) S (Shut down)
 * 
 * Your Choice:p
 * 
 * You qualify for a free yogurt. Would you like to use your credits? (Y or N) Y
 * You have just used 7 credits and have 43 left. Enjoy your free yogurt. How
 * many yogurts would you like to buy ? 10 You just earned 10 stamps and have a
 * total of 53 to use.
 * 
 * Menu: P (process Purchase) S (Shut down)
 * 
 * Your Choice:pppp
 * 
 * You qualify for a free yogurt. Would you like to use your credits? (Y or N) y
 * You have just used 7 credits and have 46 left. Enjoy your free yogurt. How
 * many yogurts would you like to buy ? 3 You just earned 3 stamps and have a
 * total of 49 to use.
 * 
 * Menu: P (process Purchase) S (Shut down)
 * 
 * Your Choice:p
 * 
 * You qualify for a free yogurt. Would you like to use your credits? (Y or N) n
 * 0000
 * 
 * How many yogurts would you like to buy ? 2 You just earned 2 stamps and have
 * a total of 51 to use.
 * 
 * Menu: P (process Purchase) S (Shut down)
 * 
 * Your Choice:s
 * 
 * -------------------------------------------------------------
 */