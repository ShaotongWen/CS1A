/**
 * @author Shaotong Wen
 * @class W19 CS F001A 06W Obj-Oriented Prog Method Java
 * @instructor Dave Harden
 * @nameOffile Assignment2.java
 */

public class Assignment2 {
	public static void main(String[] args) {
		int myId;
		int numLet;
		double doubleResult1; /* doubleResult1 will make the denominator of #3 into double type. */
		double doubleResult2; /*
								 * doubleResult2 will make the result of the (numLet+20.) of #5 into double
								 * type.
								 */

		myId = 20350617;
		numLet = 8;
		doubleResult1 = numLet + 800.;
		doubleResult2 = (numLet + 20) * (numLet + 20);

		System.out.println("My name is Shaotong Wen");
		System.out.println("My Student ID is " + myId);
		System.out.println("The numbers of my name is " + numLet);

		System.out.println("\n" + "Expression #1 --> " + (myId % 17));
		System.out.println("\n" + "Expression #2 --> " + ((numLet + 17) % 11));
		System.out.println("\n" + "Expression #3 --> " + (myId / doubleResult1));
		System.out.println("\n" + "Expression #4 --> " + ((1 + 2 + 3 + 4 + 5 + 6 + 7) + numLet));
		System.out.println("\n" + "Expression #5 --> " + (15000. / (80. + ((myId - 123456.) / doubleResult2))));
	}

}

/*
 * ---------------- sample run --------------------------------
 * 
 * My name is Shaotong Wen My Student ID is 20350617 The numbers of my name is 8
 * 
 * Expression #1 --> 2
 * 
 * Expression #2 --> 3
 * 
 * Expression #3 --> 25186.40717821782
 * 
 * Expression #4 --> 36
 * 
 * Expression #5 --> 0.5795992593549464
 * 
 * -------------------------------------------------------------
 */
