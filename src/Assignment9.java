public class Assignment9 
{
	public static void main(String[] args) 
	{
		
		Student[] array1 = new Student[0];
		Student[] array2 = { new Student("ameila", "jackson", 234) };
		Student[] array3 = { new Student("ameila", "jackson", 234),
				new Student("5asoer", "paul", 435),
				new Student("colby jarrett", "john", 344),
				new Student("drew ", "dean", 234),
				new Student("jack", "tailor", 257),
				new Student("perry", "fred", 244),
				new Student("smith", "fred", 143),
				new Student("jacobs", "carrie", 289),
				new Student("stollings", "pamela", 401),
				new Student("cassar", "john", 12),
				new Student("charters", "rodney", 345),
				new Student("mila", "chung", 111),
				new Student("3ackson", "trevor", 345),
				new Student("bauer", "jack", 232),
				new Student("loceff", "fred", 44),
				};
		
		Student[] array4 = { new Student("ameila", "jackson", 234),
				new Student("5asoer", "paul", 435),
				new Student("colby jarrett", "john", 344),
				new Student("drew ", "dean", 234),
				new Student("jack", "tailor", 257),
				new Student("perry", "fred", 244),
				new Student("smith", "fred", 143),
				new Student("jacobs", "carrie", 289),
				new Student("stollings", "pamela", 401),
				new Student("cassar", "john", 12),
				new Student("charters", "rodney", 345),
				new Student("mila", "chung", 111),
				new Student("3ackson", "trevor", 345),
				new Student("bauer", "jack", 232),
				new Student("loceff", "fred", 44),
				new Student("renquist", "abe", 182),
				};
		
		StudentArrayUtilities myStuds = new StudentArrayUtilities();
		System.out.println(myStuds.toString("Before: ",array4));

		myStuds.arraySort(array4);
		System.out.println("Sorting by default ---------------");
		System.out.println( myStuds.toString("After: ",array4));
		
		Student.setSortKey(Student.SORT_BY_FIRST);
		myStuds.arraySort(array4);
		System.out.println("Sorting by first name ---------------");
		System.out.println(myStuds.toString("After: ",array4));
		
		Student.setSortKey(Student.SORT_BY_POINTS);
		myStuds.arraySort(array4);
		System.out.println("Sorting by total points ---------------");
		System.out.println(myStuds.toString("After: ",array4));
		
		Student.setSortKey(Student.SORT_BY_FIRST);
		System.out.println("Median score of array4 = " + myStuds.getMedianDestructive(array4));
		
		if (Student.getSortKey() == Student.SORT_BY_FIRST)
			System.out.println("Successfully preserved sort key.");
		
		myStuds = new StudentArrayUtilities();
		System.out.println("Median score of array1 = " + myStuds.getMedianDestructive(array1));
		System.out.println("Median score of array2 = " + myStuds.getMedianDestructive(array2));
		System.out.println("Median score of array3 = " + myStuds.getMedianDestructive(array3));
	}
}

class Student1 
{
	
	private String lastName;
	private String firstName;
	private int totalPoints;

	public static final String DEFAULT_NAME = "zz-error";
	public static final int DEFAULT_POINTS = 0;
	public static final int MAX_POINTS = 1000;

	public static final int SORT_BY_FIRST = 88;
	public static final int SORT_BY_LAST = 98;
	public static final int SORT_BY_POINTS = 108;
	private static int sortKey = SORT_BY_LAST;

	// constructor
	public Student(String last, String first, int points) 
	{
		if (!setLastName(last))
			lastName = DEFAULT_NAME;
		if (!setFirstName(first))
			firstName = DEFAULT_NAME;
		if (!setPoints(points))
			totalPoints = DEFAULT_POINTS;
	}

	public boolean setLastName(String last) 
	{
		if (!validString(last))
			return false;
		lastName = last;
		return true;
	}

	public boolean setFirstName(String first) 
	{
		if (!validString(first))
			return false;
		firstName = first;
		return true;
	}

	public boolean setPoints(int pts) 
	{
		if (!validPoints(pts))
			return false;
		totalPoints = pts;
		return true;
	}

	public static boolean setSortKey(int key) 
	{
		if (!(key == SORT_BY_FIRST || key == SORT_BY_LAST || key == SORT_BY_POINTS))
			return false;
		sortKey = key;
		return true;
	}

	private static boolean validString(String testStr) 
	{
		if (testStr != null && Character.isLetter(testStr.charAt(0)))
			return true;
		return false;
	}

	private static boolean validPoints(int testPoints) 
	{
		if (testPoints >= 0 && testPoints <= MAX_POINTS)
			return true;
		return false;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public int getTotalPoints() 
	{
		return totalPoints;
	}

	public static int getSortKey() 
	{
		return sortKey;
	}

	public String toString() 
	{

		String resultString;

		resultString = " " + lastName + "," + firstName + " points: " + totalPoints + "\n";
		return resultString;
	}

	// this method has to compare the two Students based on the sortKey
	public static int compareTwoStudents(Student firstStud, Student secondStud) 
	{
		int result;
		switch (sortKey) 
		{
		case SORT_BY_POINTS:
			result = firstStud.totalPoints - secondStud.totalPoints;
			break;
		case SORT_BY_FIRST:
			result = firstStud.firstName.compareToIgnoreCase(secondStud.firstName);
			break;
		default:
			result = firstStud.lastName.compareToIgnoreCase(secondStud.lastName);
			break;
		}
		return result;
	}
}

class StudentArrayUtilities1 
{
	
	// replace printArray() with toString()
	public String toString(String title, Student[] data)
	{
		String output = title + "\n";
		for (int k = 0; k < data.length; k++)
			output += " " + data[k].toString();
		return output;
	}
	
	

	// This computes and
	// returns the median of the total scores of all the students
	public double getMedianDestructive(Student[] array) 
	{
		double median = 0.0;
		//returns 0.0 if the array is empty
		if (array.length == 0)
			return 0.0;
		
		//returns Student's totalPoints if the array only has one element
		if (array.length == 1)
			median = array[0].getTotalPoints();
			
		int oldKey = Student.getSortKey();
		Student.setSortKey(Student.SORT_BY_POINTS);
		arraySort(array);
		
		//returns two middle elements's average of their total points 
		//if the array has even number of elements
		switch (array.length % 2)
        {
            case 0:
            {
                median = (array[array.length / 2].getTotalPoints()
                        + (array[ array.length / 2 - 1].getTotalPoints())) / 2;
                break;
            }
            case 1:
            {
                median = (array[array.length /2 ].getTotalPoints());
                break;
            }
        }	
		Student.setSortKey(oldKey);
		return median;
	}

	private static boolean floatLargestToTop(Student[] data, int top) 
	{
		boolean changed = false;
		Student temp;

		 // compare with client call to see where the loop stops
		for (int k = 0; k < top; k++)
			if (Student.compareTwoStudents(data[k], data[k + 1]) > 0) 
			{
				temp = data[k];
				data[k] = data[k + 1];
				data[k + 1] = temp;
				changed = true;
			}
		return changed;
	}

	public void arraySort(Student[] array) 
	{
		for (int k = 0; k < array.length; k++)
			
			// compare with method def to see where inner loop stops
			if (!floatLargestToTop(array, array.length - 1 - k))
				return;
	}
}

/*
 * ---------------- sample run -------------------------------- 
Before: 
  ameila,jackson points: 234
  zz-error,paul points: 435
  colby jarrett,john points: 344
  drew ,dean points: 234
  jack,tailor points: 257
  perry,fred points: 244
  smith,fred points: 143
  jacobs,carrie points: 289
  stollings,pamela points: 401
  cassar,john points: 12
  charters,rodney points: 345
  mila,chung points: 111
  zz-error,trevor points: 345
  bauer,jack points: 232
  loceff,fred points: 44
  renquist,abe points: 182

Sorting by default ---------------
After: 
  ameila,jackson points: 234
  bauer,jack points: 232
  cassar,john points: 12
  charters,rodney points: 345
  colby jarrett,john points: 344
  drew ,dean points: 234
  jack,tailor points: 257
  jacobs,carrie points: 289
  loceff,fred points: 44
  mila,chung points: 111
  perry,fred points: 244
  renquist,abe points: 182
  smith,fred points: 143
  stollings,pamela points: 401
  zz-error,paul points: 435
  zz-error,trevor points: 345

Sorting by first name ---------------
After: 
  renquist,abe points: 182
  jacobs,carrie points: 289
  mila,chung points: 111
  drew ,dean points: 234
  loceff,fred points: 44
  perry,fred points: 244
  smith,fred points: 143
  bauer,jack points: 232
  ameila,jackson points: 234
  cassar,john points: 12
  colby jarrett,john points: 344
  stollings,pamela points: 401
  zz-error,paul points: 435
  charters,rodney points: 345
  jack,tailor points: 257
  zz-error,trevor points: 345

Sorting by total points ---------------
After: 
  cassar,john points: 12
  loceff,fred points: 44
  mila,chung points: 111
  smith,fred points: 143
  renquist,abe points: 182
  bauer,jack points: 232
  drew ,dean points: 234
  ameila,jackson points: 234
  perry,fred points: 244
  jack,tailor points: 257
  jacobs,carrie points: 289
  colby jarrett,john points: 344
  charters,rodney points: 345
  zz-error,trevor points: 345
  stollings,pamela points: 401
  zz-error,paul points: 435

Median score of array4 = 239.0
Successfully preserved sort key.
Median score of array1 = 0.0
Median score of array2 = 234.0
Median score of array3 = 244.0
 * -------------------------------------------------------------
 */
