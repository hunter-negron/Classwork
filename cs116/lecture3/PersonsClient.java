import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class PersonsClient 
{
	/*Task 1 write a static function printSameAge() that will take the array of Persons objects and the age to search for as parameters*/
	
	
	public static void main(String[] args) 
	{		
		int arrSize = 0;
		int lines = 0;
		String str ="";
		Persons p1;
		Persons []people;		
		try {
			File myFile=new File("persons.txt");
			Scanner scan=new Scanner(myFile);
			while(scan.hasNextLine()){
				str=scan.nextLine();
				++arrSize;
			}
			scan.close();
			people = new Persons[arrSize];
			scan=new Scanner(myFile);
			while(scan.hasNextLine()){
				str=scan.nextLine();
				String []tok=str.split(",");
				p1 = new Persons(tok[1], tok[0], Integer.parseInt(tok[2]));
				people[lines++] = p1;
			}
			scan.close();
			/*Write the code to prompt the user to provide an age to search for*/
			
		}
        catch(IOException ioe){ 
			System.out.println("The file can not be read");
		}		
	}
}