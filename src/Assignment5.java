/* CS 1A Lab 5
 * Shaotong Wen
 * Feb 12,2019
 * Texting processing
 */

import java.util.*;

public class Assignment5 {
	// class variables shared by more than one method
	static char keyCharacter;
	static String userInputStr, theString;
	static final int Minimum_Size = 4;
	static final String letter_Replaced = "$";

	// main method
	public static void main(String[] args) {
		getKeyCharacter();
		getString();
		maskCharacter(theString, keyCharacter);
		removeCharacter(theString, keyCharacter);
		countKey(theString, keyCharacter);
	}

	// get key character
	public static void getKeyCharacter() {
		Scanner input = new Scanner(System.in);
		String instructions;
		instructions = "Please enter a SINGLE character to act as key:";
		System.out.println(instructions);
		userInputStr = input.nextLine();
		keyCharacter = userInputStr.charAt(0);
		while (userInputStr.length() != 1 || !Character.isLetter(keyCharacter)) {
			System.out.println(instructions);
			userInputStr = input.nextLine();
			keyCharacter = userInputStr.charAt(0);
		}
	}

	// get string
	public static void getString() {
		Scanner input = new Scanner(System.in);
		String instructions;
		instructions = "Please enter a phrase or sentence >= 4 and <= 500 characters:";
		System.out.println(instructions);
		userInputStr = input.nextLine();
		theString = userInputStr;
		while (userInputStr.length() < Minimum_Size) {
			System.out.println(instructions);
			userInputStr = input.nextLine();
			theString = userInputStr;
		}
		input.close();
	}

	// replace characters
	public static void maskCharacter(String theString, char keyCharacter) {
		String myStr = "";
		for (int i = 0; i < theString.length(); ++i) {
			if (theString.charAt(i) == keyCharacter) {
				myStr += letter_Replaced;
			} else {
				myStr += theString.charAt(i);
			}
		}
		System.out.println("String with "+ keyCharacter + " masked:");
		System.out.println(myStr);
	}

	// remove characters
	public static void removeCharacter(String theString, char keyCharacter) {
		String StrRemoved = "";
		for (int i = 0; i < theString.length(); ++i) {
			if (theString.charAt(i) != keyCharacter) {
				StrRemoved += theString.charAt(i);
			}
		}
		System.out.println("String with "+ keyCharacter + " removed:");
		System.out.println(StrRemoved);
	}

	// get counts
	public static void countKey(String theString, char keyCharacter) {
		int count;
		count = 0;
		for (int i = 0; i < theString.length(); ++i) {
			if (theString.charAt(i) == keyCharacter) {
				count++;
			}
		}
		System.out.println("# Ps:" + count);
	}

}

/* ---------------------- Sample run1 ---------------------------------------
Please enter a SINGLE character to act as key:
dgkfpo
Please enter a SINGLE character to act as key:
O*(U
Please enter a SINGLE character to act as key:
p
Please enter a phrase or sentence >= 4 and <= 500 characters:
sdf
Please enter a phrase or sentence >= 4 and <= 500 characters:
asdad
String with 'p' masked:
asdad
String with 'p' removed:
asdad
# Ps:0
------------------------------------------------------------------------ */

/* ---------------------- Sample run2 ---------------------------------------
Please enter a SINGLE character to act as key:
123
Please enter a SINGLE character to act as key:
asj
Please enter a SINGLE character to act as key:
f
Please enter a phrase or sentence >= 4 and <= 500 characters:
asbfdhdjlbfldfa
String with 'f' masked:
asb$dhdjlb$ld$a
String with 'f' removed:
asbdhdjlblda
# Ps:3
------------------------------------------------------------------------ */

/* ---------------------- Sample run3 ---------------------------------------
Please enter a SINGLE character to act as key:
o
Please enter a phrase or sentence >= 4 and <= 500 characters:
skdjbsfdhjsafbao
String with 'o' masked:
skdjbsfdhjsafba$
String with 'o' removed:
skdjbsfdhjsafba
# Ps:1
------------------------------------------------------------------------ */

/* ---------------------- Sample run4 ---------------------------------------
Please enter a SINGLE character to act as key:
j
Please enter a phrase or sentence >= 4 and <= 500 characters:
sbdjhaSBDAJhkdb
String with 'j' masked:
sbd$haSBDAJhkdb
String with 'j' removed:
sbdhaSBDAJhkdb
# Ps:1
------------------------------------------------------------------------ */