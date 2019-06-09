/* CS 1A Lab 10
 * Shaotong Wen
 * March 18,2019
 * A StudentArrayUtilities Class with an Internal Array
 */

public class Assignment10 
{
	public static void main(String[] args) 
	{
	      int k;
	      Student student;
	      
	      Student[] myClass = { new Student("smith","fred", 95), 
	         new Student("bauer","jack",123),
	         new Student("jacobs","carrie", 195), 
	         new Student("renquist","abe",148),
	         new Student("3ackson","trevor", 108), 
	         new Student("perry","fred",225),
	         new Student("loceff","fred", 44), 
	         new Student("stollings","pamela",452),
	         new Student("charters","rodney", 295), 
	         new Student("cassar","john",321),
	      };
	      
	      // instantiate a StudArrUtilObject
	      StudentArrayUtilities myStuds = new StudentArrayUtilities();
	      
	      // we can add stdunts manually and individually
	      myStuds.addStudent( new Student("bartman", "petra", 102) );
	      myStuds.addStudent( new Student("charters","rodney", 295));
	      
	      // if we happen to have an array available, we can add students in loop.
	      for (k = 0; k < myClass.length; k++)
	         myStuds.addStudent( myClass[k] );

	      System.out.println( myStuds.toString("Before: "));
	      
	      myStuds.arraySort();
	      System.out.println( myStuds.toString("Sorting by default: "));
	 
	      Student.setSortKey(Student.SORT_BY_FIRST);
	      myStuds.arraySort();
	      System.out.println( myStuds.toString("Sorting by first name: "));
	      
	      Student.setSortKey(Student.SORT_BY_POINTS);
	      myStuds.arraySort();
	      System.out.println( myStuds.toString("Sorting by total points: "));
	      
	      // test median
	      System.out.println("Median of evenClass = "
	         +  myStuds.getMedianDestructive() + "\n");
	      
	      // various tests of removing and adding too many students
	      for (k = 0; k < 100; k++)
	      {
	         if ( (student = myStuds.removeStudent()) != null)
	            System.out.println("Removed " + student);
	         else
	         {
	            System.out.println("Empty after " + k + " removes.");
	            break;
	         }
	      }

	      for (k = 0; k < 100; k++)
	      {
	         if (!myStuds.addStudent(new Student("first", "last", 22)))
	         {
	            System.out.println("Full after " + k + " adds.");
	            break;
	         }
	      }
	}
}

class Student
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






class StudentArrayUtilities 
{
	
    public static final int MAX_STUDENTS = 20;
    public static final int DEFAULT_NUM_STUDENTS = 0;
    private Student[] theArray;
    private int numStudents;
    
    
    
    
    
    
    
    public StudentArrayUtilities() 
    {
        theArray = new Student[MAX_STUDENTS];
        numStudents = DEFAULT_NUM_STUDENTS;
    }
    
    
    
    
    
    
    public boolean addStudent(Student stud) 
    {
        if (stud == null || numStudents == MAX_STUDENTS)
            return false;
        theArray[numStudents++] = stud;
        return true;
    }
    
    
    
    
    
    
    public Student removeStudent() 
    {
        if (numStudents == 0)
            return null;
        return theArray[--numStudents];
    }
  
    
    
    
    
    
	// replace printArray() with toString()
	public String toString(String title)
	{
		String output = title + "\n";
		for (int k = 0; k < numStudents; k++)
			output += " " + theArray[k].toString();
		return output;
	}
		
	
	
	
	
	
	// This computes and
	// returns the median of the total scores of all the students
	public double getMedianDestructive() 
	{
		double median = 0.0;
		//returns 0.0 if the array is empty
		if (numStudents == 0)
			return 0.0;
		
		//returns Student's totalPoints if the array only has one element
		if (numStudents == 1)
			median = theArray[0].getTotalPoints();
			
		int oldKey = Student.getSortKey();
		Student.setSortKey(Student.SORT_BY_POINTS);
		arraySort();
		
		//returns two middle elements's average of their total points 
		//if the array has even number of elements
		switch (numStudents % 2)
        {
            case 0:
            {
                median = (theArray[numStudents / 2].getTotalPoints()
                        + (theArray[ numStudents / 2 - 1].getTotalPoints())) / 2;
                break;
            }
            case 1:
            {
                median = (theArray[numStudents /2 ].getTotalPoints());
                break;
            }
        }	
		Student.setSortKey(oldKey);
		return median;
	}

	
	
	
	
	
    private boolean floatLargestToTop(int top) 
    {
        boolean changed = false;
        Student temp;

        // compare with client call to see where the loop stops
        for (int k = 0; k < top; k++)
            if (Student.compareTwoStudents(theArray[k], theArray[k + 1]) > DEFAULT_NUM_STUDENTS) 
            {
                temp = theArray[k];
                theArray[k] = theArray[k + 1];
                theArray[k + 1] = temp;
                changed = true;
            }
        return changed;
    }

    
    
    
    
     
	public void arraySort() 
	{
		for (int k = 0; k < numStudents; k++)
			
			// compare with method def to see where inner loop stops
			if (!floatLargestToTop(numStudents - 1 - k))
				return;
	}
}

/*
 * ---------------- sample run -------------------------------- 
Before: 
  bartman,petra points: 102
  charters,rodney points: 295
  smith,fred points: 95
  bauer,jack points: 123
  jacobs,carrie points: 195
  renquist,abe points: 148
  zz-error,trevor points: 108
  perry,fred points: 225
  loceff,fred points: 44
  stollings,pamela points: 452
  charters,rodney points: 295
  cassar,john points: 321

Sorting by default: 
  bartman,petra points: 102
  bauer,jack points: 123
  cassar,john points: 321
  charters,rodney points: 295
  charters,rodney points: 295
  jacobs,carrie points: 195
  loceff,fred points: 44
  perry,fred points: 225
  renquist,abe points: 148
  smith,fred points: 95
  stollings,pamela points: 452
  zz-error,trevor points: 108

Sorting by first name: 
  renquist,abe points: 148
  jacobs,carrie points: 195
  loceff,fred points: 44
  perry,fred points: 225
  smith,fred points: 95
  bauer,jack points: 123
  cassar,john points: 321
  stollings,pamela points: 452
  bartman,petra points: 102
  charters,rodney points: 295
  charters,rodney points: 295
  zz-error,trevor points: 108

Sorting by total points: 
  loceff,fred points: 44
  smith,fred points: 95
  bartman,petra points: 102
  zz-error,trevor points: 108
  bauer,jack points: 123
  renquist,abe points: 148
  jacobs,carrie points: 195
  perry,fred points: 225
  charters,rodney points: 295
  charters,rodney points: 295
  cassar,john points: 321
  stollings,pamela points: 452

Median of evenClass = 171.0

Removed  stollings,pamela points: 452

Removed  cassar,john points: 321

Removed  charters,rodney points: 295

Removed  charters,rodney points: 295

Removed  perry,fred points: 225

Removed  jacobs,carrie points: 195

Removed  renquist,abe points: 148

Removed  bauer,jack points: 123

Removed  zz-error,trevor points: 108

Removed  bartman,petra points: 102

Removed  smith,fred points: 95

Removed  loceff,fred points: 44

Empty after 12 removes.
Full after 20 adds.
 * -------------------------------------------------------------
 */