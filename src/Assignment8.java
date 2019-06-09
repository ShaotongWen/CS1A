/* CS 1A Lab 8
 * Shaotong Wen
 * March 6,2019
 * Computer Dating
 */

public class Assignment8 
{
	public static void main(String[] args) 
	{
		DateProfile app1 = new DateProfile('f', 'm', 10, 5, "Sarah Somebody"),
				app2 = new DateProfile('f', 'm', 1, 8, "Steve Nobody"),
				app3 = new DateProfile('m', 'f', 2, 7, "Jane Peabody"),
				app4 = new DateProfile('f', 'm', 9, 2, "Helen Anybody");
		
		// compare each applicant to app1
		displayTwoProfiles(app1, app1);
		displayTwoProfiles(app1, app2);
		displayTwoProfiles(app1, app3);
		displayTwoProfiles(app1, app4);

		// compare each applicant to app2
		displayTwoProfiles(app2, app1);
		displayTwoProfiles(app2, app2);
		displayTwoProfiles(app2, app3);
		displayTwoProfiles(app2, app4);

		// compare each applicant to app3
		displayTwoProfiles(app3, app1);
		displayTwoProfiles(app3, app2);
		displayTwoProfiles(app3, app3);
		displayTwoProfiles(app3, app4);

		// compare each applicant to app4
		displayTwoProfiles(app4, app1);
		displayTwoProfiles(app4, app2);
		displayTwoProfiles(app4, app3);
		displayTwoProfiles(app4, app4);

		if (app4.setGender('Q'))
			System.out.println("Q accepted as gender");
		else
			System.out.println("Q rejected as gender");
	}

	static void displayTwoProfiles(DateProfile profile1, DateProfile profile2) 
	{
		System.out.println("Fit between " + profile1.getName() + " and " + profile2.getName() + ":" + "   "
				+ profile1.fitValue(profile2));
	}

}

class DateProfile 
{

	private char gender;
	private char searchGender;
	private int romance;
	private int finance;
	private String name;

	public static final int DEFAULT_FINANCE = 1;
	public static final int DEFAULT_ROMANCE = 1;
	public static final char DEFAULT_GENDER = 'm';
	public static final char DEFAULT_SEARCH_GENDER = 'f';
	public static final String DEFAULT_NAME = "undefined";

	public static final int MIN_VALUE = 1;
	public static final int MAX_VALUE = 10;
	public static final int MIN_NAME_LENGTH = 5;
	public static final int MAX_NAME_LENGTH = 100;

	// default constructor
	DateProfile() 
	{
		setDefaults();
	}

	// parameter-taking constructor
	DateProfile(char gen, char seaGend, int rom, int fin, String nam) 
	{
		setDefaults();
		setAll(gen, seaGend, rom, fin, nam);
	}

	void setDefaults() 
	{
		gender = DEFAULT_GENDER;
		searchGender = DEFAULT_SEARCH_GENDER;
		finance = DEFAULT_FINANCE;
		romance = DEFAULT_ROMANCE;
		name = DEFAULT_NAME;
	}

	public double fitValue(DateProfile partner) 
	{
		double genValue, finValue, romValue, retValue;
		genValue = determineGenderFit(partner);
		romValue = determineRomanceFit(partner);
		finValue = determineFinanceFit(partner);
		retValue = genValue * (romValue + finValue) / 2.;
		return retValue;
	}

	// helpers
	private double determineGenderFit(DateProfile partner) 
	{
		if (searchGender != partner.gender)
			return 0.0;
		if (partner.searchGender != gender)
			return 0.0;
		return 1.0;
	}

	private double determineRomanceFit(DateProfile partner) 
	{
		int difference;
		double fit;
		difference = Math.abs(romance - partner.romance); // returns the absolute value
		fit = MAX_VALUE - difference;
		fit = fit / (double) MAX_VALUE-0.1;
		fit +=.1;
		return fit;
	}

	private double determineFinanceFit(DateProfile partner) 
	{
		int difference;
		double fit;
		difference = Math.abs(finance - partner.finance);
		fit = MAX_VALUE - difference;
		fit = fit / (double) MAX_VALUE- 0.1;
		fit +=.1;
		return fit;
	}

	// mutators
	void setAll(char gen, char seaGend, int rom, int fin, String nam) 
	{
		setGender(gen);
		setSearchGender(seaGend);
		setRomance(rom);
		setFinance(fin);
		setName(nam);
	}

	boolean setGender(char gen) 
	{
		char newGender = Character.toLowerCase(gen);
		if (newGender != 'm' && newGender != 'f')
			return false;
		else
			gender = gen;
		return true;
	}

	boolean setSearchGender(char seaGend) 
	{
		char newSearchGender = Character.toLowerCase(seaGend);
		if (newSearchGender != 'm' && newSearchGender != 'f')
			return false;
		else
			searchGender = seaGend;
		return true;
	}

	boolean setRomance(int rom) 
	{
		if (rom < MIN_VALUE || rom > MAX_VALUE)
			return false;
		romance = rom;
		return true;
	}

	boolean setFinance(int fin) 
	{
		if (fin < MIN_VALUE || fin > MAX_VALUE)
			return false;
		finance = fin;
		return true;
	}

	boolean setName(String nam) 
	{
		if (nam.length() < MIN_NAME_LENGTH || nam.length() > MAX_NAME_LENGTH)
			return false;
		name = nam;
		return true;
	}

	// accessors
	char getGender() 
	{
		return gender;
	}

	char getSearchGender() 
	{
		return searchGender;
	}

	int getRomance() 
	{
		return romance;
	}

	int getFinance() 
	{
		return finance;
	}

	String getName() 
	{
		return name;
	}
}

/*
 * ---------------- sample run -------------------------------- 
Fit between Sarah Somebody and Sarah Somebody:   0.0
Fit between Sarah Somebody and Steve Nobody:   0.0
Fit between Sarah Somebody and Jane Peabody:   0.5
Fit between Sarah Somebody and Helen Anybody:   0.0
Fit between Steve Nobody and Sarah Somebody:   0.0
Fit between Steve Nobody and Steve Nobody:   0.0
Fit between Steve Nobody and Jane Peabody:   0.9
Fit between Steve Nobody and Helen Anybody:   0.0
Fit between Jane Peabody and Sarah Somebody:   0.5
Fit between Jane Peabody and Steve Nobody:   0.9
Fit between Jane Peabody and Jane Peabody:   0.0
Fit between Jane Peabody and Helen Anybody:   0.4
Fit between Helen Anybody and Sarah Somebody:   0.0
Fit between Helen Anybody and Steve Nobody:   0.0
Fit between Helen Anybody and Jane Peabody:   0.4
Fit between Helen Anybody and Helen Anybody:   0.0
Q rejected as gender
 */