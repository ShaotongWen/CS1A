/**
 * @author Shaotong Wen
 * @class  CS 1A
 * @instructor Dave Harden
 * @date January 28
 */

/**
 * Description:
 * Entering the amount of food and serving number of foods 
 * will return some nutritional informations.
 */

// ---------------- SOURCE -------------------------
import java.util.Scanner;

public class Assignment3 {
	// food #1 constants
	static final String FOOD_1_NAME = "avocado";
	static final int FOOD_1_CALORIES_P100G = 160; // in calories
	static final double FOOD_1_SOL_FIBER_P100G = 1.75; // in grams
	static final double FOOD_1_PROTEIN_P100G = 2; // in grams
	static final double FOOD_1_FAT_P100G = 14.7; // in grams
	static final double FOOD_1_VITAMINC__P100G = 10.00; // in milligrams

	// food #2 constants
	static final String FOOD_2_NAME = "tomato";
	static final int FOOD_2_CALORIES_P100G = 81; // in calories
	static final double FOOD_2_SOL_FIBER_P100G = 1.1; // in grams
	static final double FOOD_2_PROTEIN_P100G = 4.3; // in grams
	static final double FOOD_2_FAT_P100G = 1.9; // in grams
	static final double FOOD_2_VITAMINC__P100G = 1.9; // in milligrams

	// food #3 constants
	static final String FOOD_3_NAME = "buffalo mozzarella";
	static final int FOOD_3_CALORIES_P100G = 425; // in calories
	static final double FOOD_3_SOL_FIBER_P100G = 2.; // in grams
	static final double FOOD_3_PROTEIN_P100G = 18.0; // in grams
	static final double FOOD_3_FAT_P100G = 22.5; // in grams
	static final double FOOD_3_VITAMINC__P100G = 0.6; // in milligrams

	// food #4 constants
	static final String FOOD_4_NAME = "olive oil";
	static final int FOOD_4_CALORIES_P100G = 844; // in calories
	static final double FOOD_4_SOL_FIBER_P100G = 0.; // in grams
	static final double FOOD_4_PROTEIN_P100G = 0.; // in grams
	static final double FOOD_4_FAT_P100G = 100; // in grams
	static final double FOOD_4_VITAMINC__P100G = 0.; // in milligrams

	// food #5 constants
	static final String FOOD_5_NAME = "pasta";
	static final int FOOD_5_CALORIES_P100G = 60; // in calories
	static final double FOOD_5_SOL_FIBER_P100G = 1.5; // in grams
	static final double FOOD_5_PROTEIN_P100G = 1.7; // in grams
	static final double FOOD_5_FAT_P100G = 2.1; // in grams
	static final double FOOD_5_VITAMINC__P100G = 2.9; // in grams

	// food #6 constants
	static final String FOOD_6_NAME = "tofu";
	static final int FOOD_6_CALORIES_P100G = 480; // in calories
	static final double FOOD_6_SOL_FIBER_P100G = 7.2; // in grams
	static final double FOOD_6_PROTEIN_P100G = 47.9; // in grams
	static final double FOOD_6_FAT_P100G = 30.3; // in grams
	static final double FOOD_6_VITAMINC__P100G = 0.7; // in grams

	static final String INDENT = "   ";
	static final String SEPARATOR = "\n";

	static final int FOOD_AMOUNT_MINIMUM_LIMIT = 0;
	static final int FOOD_AMOUNT_MAXIMUM_LIMIT = 1500;
	static final int SERVING_NUMBER_MINIMUM_LIMIT = 1;
	static final int SERVING_NUMBER_MAXIMUM_LIMIT = 15;
	static final String ERROR_LANGUAGE_1 = "Please enter an amount (grams) between 0 and 1500!";
	static final String ERROR_LANGUAGE_2 = "Please enter a number of servings between 1 and 15!";

	public static void main(String[] args) {
		String recipeName, userInputStr, servingNumber;
		int userInputInt, servingNumberInt;
		double totalSolFiber, totalCals, totalProtein, totalFat, totalVitaminC;
		Scanner inputStream = new Scanner(System.in);

		// initialize accumulator variables
		totalSolFiber = 0.;
		totalCals = 0;
		totalProtein = 0;
		totalFat = 0;
		totalVitaminC = 0;

		// print menu
		System.out.println("---------- List of Possible Ingredients ---------");
		System.out.println(INDENT + "Food #1: " + FOOD_1_NAME);
		System.out.println(INDENT + "Food #2: " + FOOD_2_NAME);
		System.out.println(INDENT + "Food #3: " + FOOD_3_NAME);
		System.out.println(INDENT + "Food #4: " + FOOD_4_NAME);
		System.out.println(INDENT + "Food #5: " + FOOD_5_NAME);
		System.out.println(INDENT + "Food #6: " + FOOD_6_NAME + SEPARATOR);

		// name of recipe
		System.out.print("What are you calling this recipe ? ");
		recipeName = inputStream.nextLine();

		// food #1 ---------------------------------------------------------
		System.out.print("How many grams of " + FOOD_1_NAME + "? ");
		userInputStr = inputStream.nextLine();
		userInputInt = Integer.parseInt(userInputStr);
		if (userInputInt < FOOD_AMOUNT_MINIMUM_LIMIT || userInputInt > FOOD_AMOUNT_MAXIMUM_LIMIT) {
			System.out.println(ERROR_LANGUAGE_1);
			System.exit(0);
		}
		System.out.print("How many servings of " + FOOD_1_NAME + "? ");
		servingNumber = inputStream.nextLine();
		servingNumberInt = Integer.parseInt(servingNumber);
		if (servingNumberInt < SERVING_NUMBER_MINIMUM_LIMIT || servingNumberInt > SERVING_NUMBER_MAXIMUM_LIMIT) {
			System.out.println(ERROR_LANGUAGE_2);
			System.exit(0);
		}
		// update accumulators
		totalCals += ((userInputInt * (FOOD_1_CALORIES_P100G / 100.)) / servingNumberInt);
		totalSolFiber += ((userInputInt * (FOOD_1_SOL_FIBER_P100G / 100.)) / servingNumberInt);
		totalProtein += ((userInputInt * (FOOD_1_PROTEIN_P100G / 100.)) / servingNumberInt);
		totalFat += ((userInputInt * (FOOD_1_FAT_P100G / 100.)) / servingNumberInt);
		totalVitaminC += ((userInputInt * (FOOD_1_VITAMINC__P100G / 100.)) / servingNumberInt);

		// food #2 ---------------------------------------------------------
		System.out.print("How many grams of " + FOOD_2_NAME + "? ");
		userInputStr = inputStream.nextLine();
		userInputInt = Integer.parseInt(userInputStr);
		if (userInputInt < FOOD_AMOUNT_MINIMUM_LIMIT || userInputInt > FOOD_AMOUNT_MAXIMUM_LIMIT) {
			System.out.println(ERROR_LANGUAGE_1);
			System.exit(0);
		}
		System.out.print("How many servings of " + FOOD_2_NAME + "? ");
		servingNumber = inputStream.nextLine();
		servingNumberInt = Integer.parseInt(servingNumber);
		if (servingNumberInt < SERVING_NUMBER_MINIMUM_LIMIT || servingNumberInt > SERVING_NUMBER_MAXIMUM_LIMIT) {
			System.out.println(ERROR_LANGUAGE_2);
			System.exit(0);
		}
		// update accumulators
		totalCals += ((userInputInt * (FOOD_2_CALORIES_P100G / 100.)) / servingNumberInt);
		totalSolFiber += ((userInputInt * (FOOD_2_SOL_FIBER_P100G / 100.)) / servingNumberInt);
		totalProtein += ((userInputInt * (FOOD_2_PROTEIN_P100G / 100.)) / servingNumberInt);
		totalFat += ((userInputInt * (FOOD_2_FAT_P100G / 100.)) / servingNumberInt);
		totalVitaminC += ((userInputInt * (FOOD_2_VITAMINC__P100G / 100.)) / servingNumberInt);

		// food #3 ---------------------------------------------------------
		System.out.print("How many grams of " + FOOD_3_NAME + "? ");
		userInputStr = inputStream.nextLine();
		userInputInt = Integer.parseInt(userInputStr);
		if (userInputInt < FOOD_AMOUNT_MINIMUM_LIMIT || userInputInt > FOOD_AMOUNT_MAXIMUM_LIMIT) {
			System.out.println(ERROR_LANGUAGE_1);
			System.exit(0);
		}
		System.out.print("How many servings of " + FOOD_3_NAME + "? ");
		servingNumber = inputStream.nextLine();
		servingNumberInt = Integer.parseInt(servingNumber);
		if (servingNumberInt < SERVING_NUMBER_MINIMUM_LIMIT || servingNumberInt > SERVING_NUMBER_MAXIMUM_LIMIT) {
			System.out.println(ERROR_LANGUAGE_2);
			System.exit(0);
		}
		// update accumulators
		totalCals += ((userInputInt * (FOOD_3_CALORIES_P100G / 100.)) / servingNumberInt);
		totalSolFiber += ((userInputInt * (FOOD_3_SOL_FIBER_P100G / 100.)) / servingNumberInt);
		totalProtein += ((userInputInt * (FOOD_3_PROTEIN_P100G / 100.)) / servingNumberInt);
		totalFat += ((userInputInt * (FOOD_3_FAT_P100G / 100.)) / servingNumberInt);
		totalVitaminC += ((userInputInt * (FOOD_3_VITAMINC__P100G / 100.)) / servingNumberInt);

		// food #4 ---------------------------------------------------------
		System.out.print("How many grams of " + FOOD_4_NAME + "? ");
		userInputStr = inputStream.nextLine();
		userInputInt = Integer.parseInt(userInputStr);
		if (userInputInt < FOOD_AMOUNT_MINIMUM_LIMIT || userInputInt > FOOD_AMOUNT_MAXIMUM_LIMIT) {
			System.out.println(ERROR_LANGUAGE_1);
			System.exit(0);
		}
		System.out.print("How many servings of " + FOOD_4_NAME + "? ");
		servingNumber = inputStream.nextLine();
		servingNumberInt = Integer.parseInt(servingNumber);
		if (servingNumberInt < SERVING_NUMBER_MINIMUM_LIMIT || servingNumberInt > SERVING_NUMBER_MAXIMUM_LIMIT) {
			System.out.println(ERROR_LANGUAGE_2);
			System.exit(0);
		}
		// update accumulators
		totalCals += ((userInputInt * (FOOD_4_CALORIES_P100G / 100.)) / servingNumberInt);
		totalSolFiber += ((userInputInt * (FOOD_4_SOL_FIBER_P100G / 100.)) / servingNumberInt);
		totalProtein += ((userInputInt * (FOOD_4_PROTEIN_P100G / 100.)) / servingNumberInt);
		totalFat += ((userInputInt * (FOOD_4_FAT_P100G / 100.)) / servingNumberInt);
		totalVitaminC += ((userInputInt * (FOOD_4_VITAMINC__P100G / 100.)) / servingNumberInt);

		// food #5 ---------------------------------------------------------
		System.out.print("How many grams of " + FOOD_5_NAME + "? ");
		userInputStr = inputStream.nextLine();
		userInputInt = Integer.parseInt(userInputStr);
		if (userInputInt < FOOD_AMOUNT_MINIMUM_LIMIT || userInputInt > FOOD_AMOUNT_MAXIMUM_LIMIT) {
			System.out.println(ERROR_LANGUAGE_1);
			System.exit(0);
		}
		System.out.print("How many servings of " + FOOD_5_NAME + "? ");
		servingNumber = inputStream.nextLine();
		servingNumberInt = Integer.parseInt(servingNumber);
		if (servingNumberInt < SERVING_NUMBER_MINIMUM_LIMIT || servingNumberInt > SERVING_NUMBER_MAXIMUM_LIMIT) {
			System.out.println(ERROR_LANGUAGE_2);
			System.exit(0);
		}
		// update accumulators
		totalCals += ((userInputInt * (FOOD_5_CALORIES_P100G / 100.)) / servingNumberInt);
		totalSolFiber += ((userInputInt * (FOOD_5_SOL_FIBER_P100G / 100.)) / servingNumberInt);
		totalProtein += ((userInputInt * (FOOD_5_PROTEIN_P100G / 100.)) / servingNumberInt);
		totalFat += ((userInputInt * (FOOD_5_FAT_P100G / 100.)) / servingNumberInt);
		totalVitaminC += ((userInputInt * (FOOD_5_VITAMINC__P100G / 100.)) / servingNumberInt);

		// food #6 ---------------------------------------------------------
		System.out.print("How many grams of " + FOOD_6_NAME + "? ");
		userInputStr = inputStream.nextLine();
		userInputInt = Integer.parseInt(userInputStr);
		if (userInputInt < FOOD_AMOUNT_MINIMUM_LIMIT || userInputInt > FOOD_AMOUNT_MAXIMUM_LIMIT) {
			System.out.println(ERROR_LANGUAGE_1);
			System.exit(0);
		}
		System.out.print("How many servings of " + FOOD_6_NAME + "? ");
		servingNumber = inputStream.nextLine();
		servingNumberInt = Integer.parseInt(servingNumber);
		if (servingNumberInt < SERVING_NUMBER_MINIMUM_LIMIT || servingNumberInt > SERVING_NUMBER_MAXIMUM_LIMIT) {
			System.out.println(ERROR_LANGUAGE_2);
			System.exit(0);
		}
		// update accumulators
		totalCals += ((userInputInt * (FOOD_6_CALORIES_P100G / 100.)) / servingNumberInt);
		totalSolFiber += ((userInputInt * (FOOD_6_SOL_FIBER_P100G / 100.)) / servingNumberInt);
		totalProtein += ((userInputInt * (FOOD_6_PROTEIN_P100G / 100.)) / servingNumberInt);
		totalFat += ((userInputInt * (FOOD_6_FAT_P100G / 100.)) / servingNumberInt);
		totalVitaminC += ((userInputInt * (FOOD_6_VITAMINC__P100G / 100.)) / servingNumberInt);
		inputStream.close();

		// report results --------------------------------------------------
		System.out.println("\nNutrition for " + recipeName + "------------");
		System.out.println(INDENT + "Calories: " + totalCals);
		System.out.println(INDENT + "Soluble Fiber: " + totalSolFiber + " grams");
		System.out.println(INDENT + "Protein: " + totalProtein + " grams");
		System.out.println(INDENT + "Fat: " + totalFat + " grams");
		System.out.println(INDENT + "Vitamin C: " + (totalVitaminC * 1000) + " milligrams"); // Converts milligrams from
																								// grams
	}

}

/*
 * ---------------- sample run -------------------------------- ---------- List
 * of Possible Ingredients --------- Food #1: avocado Food #2: tomato Food #3:
 * buffalo mozzarella Food #4: olive oil Food #5: pasta Food #6: tofu
 * 
 * What are you calling this recipe ? pizza How many grams of avocado? 400 How
 * many servings of avocado? 4 How many grams of tomato? 378 How many servings
 * of tomato? 9 How many grams of buffalo mozzarella? 23 How many servings of
 * buffalo mozzarella? 2 How many grams of olive oil? 985 How many servings of
 * olive oil? 3 How many grams of pasta? 239 How many servings of pasta? 2 How
 * many grams of tofu? 234 How many servings of tofu? 1
 * 
 * Nutrition for pizza------------ Calories: 4208.928333333333 Soluble Fiber:
 * 21.082500000000003 grams Protein: 119.9935 grams Fat: 419.83033333333333
 * grams Vitamin C: 15970.5 milligrams
 * -------------------------------------------------------------
 */

/*
 * ---------------- sample run2 -------------------------------- ---------- List
 * of Possible Ingredients --------- Food #1: avocado Food #2: tomato Food #3:
 * buffalo mozzarella Food #4: olive oil Food #5: pasta Food #6: tofu
 * 
 * What are you calling this recipe ? five guys cheese burger How many grams of
 * avocado? 777 How many servings of avocado? 7 How many grams of tomato? 678
 * How many servings of tomato? 10 How many grams of buffalo mozzarella? 356 How
 * many servings of buffalo mozzarella? 3 How many grams of olive oil? 345 How
 * many servings of olive oil? 3 How many grams of pasta? 89 How many servings
 * of pasta? 6 How many grams of tofu? 239 How many servings of tofu? 1
 * 
 * Nutrition for five guys cheese burger------------ Calories:
 * 2863.5513333333333 Soluble Fiber: 22.492133333333335 grams Protein:
 * 141.22856666666667 grams Fat: 232.0337 grams Vitamin C: 15203.366666666665
 * milligrams
 * 
 * -------------------------------------------------------------
 */

/*
 * ---------------- sample run3 -------------------------------- ---------- List
 * of Possible Ingredients --------- Food #1: avocado Food #2: tomato Food #3:
 * buffalo mozzarella Food #4: olive oil Food #5: pasta Food #6: tofu
 * 
 * What are you calling this recipe ? panda fired rice How many grams of
 * avocado? 1000 How many servings of avocado? 10 How many grams of tomato? 999
 * How many servings of tomato? 9 How many grams of buffalo mozzarella? 88 How
 * many servings of buffalo mozzarella? 8 How many grams of olive oil? 777 How
 * many servings of olive oil? 7 How many grams of pasta? 666 How many servings
 * of pasta? 6 How many grams of tofu? 555 How many servings of tofu? 5
 * 
 * Nutrition for panda fired rice------------ Calories: 1832.8999999999999
 * Soluble Fiber: 12.848000000000003 grams Protein: 63.809 grams Fat: 166.248
 * grams Vitamin C: 16171.0 milligrams
 * -------------------------------------------------------------
 */

/*
 * ---------------- sample run4 -------------------------------- ---------- List
 * of Possible Ingredients --------- Food #1: avocado Food #2: tomato Food #3:
 * buffalo mozzarella Food #4: olive oil Food #5: pasta Food #6: tofu
 * 
 * What are you calling this recipe ? pasta How many grams of avocado? 111 How
 * many servings of avocado? 1 How many grams of tomato? 134 How many servings
 * of tomato? 3 How many grams of buffalo mozzarella? 456 How many servings of
 * buffalo mozzarella? 5 How many grams of olive oil? 343 How many servings of
 * olive oil? 7 How many grams of pasta? 3454 Please enter an amount (grams)
 * between 0 and 1500!
 * -------------------------------------------------------------
 */

/*
 * ---------------- sample run5 -------------------------------- ---------- List
 * of Possible Ingredients --------- Food #1: avocado Food #2: tomato Food #3:
 * buffalo mozzarella Food #4: olive oil Food #5: pasta Food #6: tofu
 * 
 * What are you calling this recipe ? steak How many grams of avocado? 222 How
 * many servings of avocado? 2 How many grams of tomato? 213 How many servings
 * of tomato? 3 How many grams of buffalo mozzarella? 584 How many servings of
 * buffalo mozzarella? 3 How many grams of olive oil? 543 How many servings of
 * olive oil? 10 How many grams of pasta? 345 How many servings of pasta? 5 How
 * many grams of tofu? 289 How many servings of tofu? 9
 * 
 * Nutrition for steak------------ Calories: 1716.2686666666668 Soluble Fiber:
 * 9.963833333333334 grams Protein: 56.867222222222225 grams Fat:
 * 126.94466666666668 grams Vitamin C: 15842.777777777777 milligrams
 * -------------------------------------------------------------
 */