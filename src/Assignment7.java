
/* CS 1A Lab 7
 * Shaotong Wen
 * Feb 27,2019
 * Casino with Methods and a Class
 */

import java.util.*;
import java.lang.Math;

public class Assignment7 
{
	// main method
	public static void main(String[] args) 
	{
		int userBet, multiplier, winnings;
		TripleString thePull;

		while ((userBet = getBet()) != QUIT_NUM) 
		{
			thePull = pull();
			multiplier = getPayMultiplier(thePull);
			winnings = multiplier * userBet;
			display(thePull, winnings);
		}
		System.out.println("Thanks for coming to Casino Loceff");
	}

	// constants
	static final String CHERRIES = " cherries ";
	static final String SEVEN = " 7 ";
	static final String BAR = " BAR ";
	static final String SPACE = " (space) ";
	static final int MAX_BET = 50;
	static final int MIN_BET = 1;
	static final int QUIT_NUM = 0;
	static final int ONE_CHERRIES_TIMES = 5;
	static final int TWO_CHERRIES_TIMES = 15;
	static final int THREE_CHERRIES_TIMES = 30;
	static final int ALL_BAR_TIMES = 50;
	static final int ALL_SEVEN_TIMES = 100;

	static final int BAR_PRB = 38;
	static final int CHERRIES_PRB = 40;
	static final int SPACE_PRB = 7;
	static final int SEVEN_PRB = 15;

	// prompts the user for input and returns the bet amount as a functional return.
	public static int getBet() 
	{
		String userInputStr;
		Scanner input = new Scanner(System.in);
		int userBet;
		do 
		{
			System.out.print(
					"How much would you like to bet (" + MIN_BET + " - " + MAX_BET + ") or " + QUIT_NUM + " to quit? ");
			userInputStr = input.nextLine();
			userBet = Integer.parseInt(userInputStr);
		} while (userBet != QUIT_NUM && (userBet < 1 || userBet > MAX_BET));
		return userBet;
	}

	public static TripleString pull() 
	{
		TripleString retString = new TripleString();
		retString.setString1(randString());
		retString.setString2(randString());
		retString.setString3(randString());
		return retString;
	}

	public static String randString() 
	{
		int randomNum;
		int bar1, cherries1, space1;

		// produces a number between 0 and 999
		randomNum = (int) (Math.random() * 1000);

		bar1 = 10 * BAR_PRB;
		cherries1 = bar1 + 10 * CHERRIES_PRB;
		space1 = cherries1 + 10 * SPACE_PRB;

		if (randomNum < bar1)
			return BAR;
		else if (randomNum < cherries1)
			return CHERRIES;
		else if (randomNum < space1)
			return SPACE;
		else
			return SEVEN;
	}

	public static int getPayMultiplier(TripleString thePull) 
	{

		if (thePull.getString1().equals(CHERRIES)) 
		{
			if (!thePull.getString2().equals(CHERRIES))
				return ONE_CHERRIES_TIMES;
			else if (!thePull.getString3().equals(CHERRIES))
				return TWO_CHERRIES_TIMES;
			else
				return THREE_CHERRIES_TIMES;
		}

		else if (thePull.getString1().equals(BAR) && thePull.getString2().equals(BAR)
				&& thePull.getString3().equals(BAR))
			return ALL_BAR_TIMES;

		else if (thePull.getString1().equals(SEVEN) && thePull.getString2().equals(SEVEN)
				&& thePull.getString3().equals(SEVEN))
			return ALL_SEVEN_TIMES;

		return 0;
	}

	public static void display(TripleString thePull, int winnings) 
	{
		System.out.println("whirrrrrr .... and your pull is ... ");
		System.out.println(thePull.toString());

		if (winnings > 0)
			System.out.println("congratulations, you win: " + winnings);
		else
			System.out.println("sorry, you lose.");
		System.out.println();
	}
}

class TripleString 
{
	private String string1;
	private String string2;
	private String string3;

	// static constants
	static final int MIN_LEN = 1;
	static final int MAX_LEN = 50;
	static final String DEFAULT_STRING = "undefined";

	// default constructor
	TripleString() 
	{
		string1 = DEFAULT_STRING;
		string2 = DEFAULT_STRING;
		string3 = DEFAULT_STRING;
	}

	// 3-parameter constructor
	TripleString(String Str1, String Str2, String Str3) 
	{
		if (!setString1(Str1))
			string1 = DEFAULT_STRING;
		if (!setString2(Str2))
			string2 = DEFAULT_STRING;
		if (!setString3(Str3))
			string3 = DEFAULT_STRING;
	}

	// accessor "set" method -------------------------------
	public boolean setString1(String theString1) 
	{
		if (!validString(theString1))
			return false;
		string1 = theString1;
		return true;
	}

	public boolean setString2(String theString2) 
	{
		if (!validString(theString2))
			return false;
		string2 = theString2;
		return true;
	}

	public boolean setString3(String theString3) 
	{
		if (!validString(theString3))
			return false;
		string3 = theString3;
		return true;
	}

	// accessor "get" methods --------------------------------
	public String getString1() 
	{
		return string1;
	}

	public String getString2() 
	{
		return string2;
	}

	public String getString3() 
	{
		return string3;
	}

	public boolean validString(String str) 
	{
		if (str == null || str.length() < MIN_LEN || str.length() > MAX_LEN)
			return false;
		return true;
	}

	// returns formed string
	public String toString() 
	{
		String reStr = string1 + "" + string2 + "" + string3;
		return reStr;
	}
}

/*
 * ----------------------------- sample run ---------------------------------
 * How much would you like to bet (1 - 50) or 0 to quit? 2 whirrrrrr .... and
 * your pull is ... BAR cherries (space) sorry, you lose.
 * 
 * How much would you like to bet (1 - 50) or 0 to quit? 2 whirrrrrr .... and
 * your pull is ... cherries cherries BAR congratulations, you win: 30
 * 
 * How much would you like to bet (1 - 50) or 0 to quit? 2 whirrrrrr .... and
 * your pull is ... cherries (space) BAR congratulations, you win: 10
 * 
 * How much would you like to bet (1 - 50) or 0 to quit? 2 whirrrrrr .... and
 * your pull is ... cherries BAR 7 congratulations, you win: 10
 * 
 * How much would you like to bet (1 - 50) or 0 to quit? 2 whirrrrrr .... and
 * your pull is ... BAR cherries BAR sorry, you lose.
 * 
 * How much would you like to bet (1 - 50) or 0 to quit? 2 whirrrrrr .... and
 * your pull is ... cherries 7 BAR congratulations, you win: 10
 * 
 * How much would you like to bet (1 - 50) or 0 to quit? 2 whirrrrrr .... and
 * your pull is ... cherries cherries 7 congratulations, you win: 30
 * 
 * How much would you like to bet (1 - 50) or 0 to quit? 2 whirrrrrr .... and
 * your pull is ... 7 cherries cherries sorry, you lose.
 * 
 * How much would you like to bet (1 - 50) or 0 to quit? 2 whirrrrrr .... and
 * your pull is ... cherries BAR cherries congratulations, you win: 10
 * 
 * How much would you like to bet (1 - 50) or 0 to quit? 2 whirrrrrr .... and
 * your pull is ... cherries BAR BAR congratulations, you win: 10
 * 
 * How much would you like to bet (1 - 50) or 0 to quit? 2 whirrrrrr .... and
 * your pull is ... BAR 7 BAR sorry, you lose.
 * 
 * How much would you like to bet (1 - 50) or 0 to quit? 0 Thanks for coming to
 * Casino Loceff
 * -------------------------------------------------------------------
 */