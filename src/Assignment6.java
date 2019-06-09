/* CS 1A Lab 6
 * Shaotong Wen
 * Feb 18,2019
 * A Triple String Class
 */

public class Assignment6 {
	public static void main(String[] args) 
	{

		// using the default constructor --------------------------------
		TripleString object1, object2;

		object1 = new TripleString();
		object2 = new TripleString();

		// using the constructor that takes parameters --------------------------------
		TripleString object3 = new TripleString("This is the first parameter of object3.",
				"This is the second parameter of object3.", "This is the third parameter of object3.");
		TripleString object4 = new TripleString("This is the first parameter of object4.",
				"This is the first parameter of object4.", "This is the first parameter of object4.");
		System.out.println("-------------- Display all objects a first time --------------");
		
		// Immediately display all objects
		System.out.println(object1.getString1() + "|" + object2.getString2());
		System.out.println(object3.getString1() + "|" + object3.getString2() + "|" + object3.getString3());
		System.out.println(object4.getString1() + "|" + object4.getString2() + "|" + object4.getString3());

		// Mutate one or more members of every object
		object1.setString1("This is the third parameter of object1.");
		object2.setString2("This is the third parameter of object2.");

		// Display all objects a second time
		System.out.println("\n" + "-------------- Display all objects a second time--------------");
		System.out.println(object1.getString1() + "|" + object2.getString2());
		System.out.println(object3.getString1() + "|" + object3.getString2() + "|" + object3.getString3());
		System.out.println(object4.getString1() + "|" + object4.getString2() + "|" + object4.getString3());

		// Do two explicit mutator tests
		System.out.println("\n" + "-------------- Two explicit mutator tests--------------");
		
		// input is null
		if (object1.setString1(""))
			System.out.println("\n" + "The call is successful.");
		else
			System.out.println("The call fails.");

		// input is longer than 50 characters
		if (object2.setString1("We’ve not known each other for that a long time. "
				+ "And there’re three things you should know about me. "
				+ "One, my friends are the most important thing in my life. " 
				+ "Two, I never lie. "
				+ "And three, I make the best oatmeal raisin cookies in the world."))
			System.out.println("The call is successful.");
		else
			System.out.println("The call fails.");

		// Make two accessor calls
		object1.getString1();
		object2.getString2();

		System.out.println("\n" + "-------------- Test toString method--------------");
		
		// test toString method
		System.out.println(object4.toString());
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
	TripleString() {
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
		String reStr = string1 + "|" + string2 + "|" + string3;
		return reStr;
	}
}

/*
 * ---------------------- Sample run ---------------------------------------
 * -------------- Display all objects a first time --------------
 * undefined|undefined This is the first parameter of object3.|This is the
 * second parameter of object3.|This is the third parameter of object3. This is
 * the first parameter of object4.|This is the first parameter of object4.|This
 * is the first parameter of object4.
 * 
 * -------------- Display all objects a second time-------------- This is the
 * third parameter of object1.|This is the third parameter of object2. This is
 * the first parameter of object3.|This is the second parameter of object3.|This
 * is the third parameter of object3. This is the first parameter of
 * object4.|This is the first parameter of object4.|This is the first parameter
 * of object4.
 * 
 * -------------- Two explicit mutator tests-------------- The call fails. The
 * call fails.
 * 
 * -------------- Test toString method-------------- This is the first parameter
 * of object4.|This is the first parameter of object4.|This is the first
 * parameter of object4.
 * ------------------------------------------------------------------------
 */
