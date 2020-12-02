import java.io.*;
import java.util.*;

public class Save {
	
	private String filename;
	private FileWriter fstream;
	Add attendance = new Add();
	Student student = new Student();
	String id;
	String min;
	String firstName;
	String program;
	String lastName;
	String username;
	String level;
	/**
	 * This method prints the information into a csv file using the information given by the main class.
	 * 
	 * , is used to move from column to column
	 * 
	 * lineSeperator is used to move to next row
	 * 
	 * @param namedFile
	 * @param idNum
	 * @param firstName
	 * @param lastName
	 * @param level
	 * @param program
	 * @param username
	 * @param minutes
	 */
	void writeFile(String namedFile, LinkedList<Student> studentList)
	{
		
		try
		{
			filename = namedFile;
			fstream = new FileWriter(filename, true); //true tells to append data.
			
			/*
			 *  idNum and minutes need to be converted to Strings first so I could write them out
			 */
			for(int i = 0; i < studentList.size(); i++)
		    {
				min = String.valueOf(attendance); //No attendance accessor set up
				firstName = studentList.get(i).getFirst();
				lastName = studentList.get(i).getLast();
				program = studentList.get(i).getProg();
				level = studentList.get(i).getLevel();
				id = studentList.get(i).getID();
				username = studentList.get(i).getASUrite();
				fstream.write(id); 
				fstream.write(",");
				fstream.write(firstName);
				fstream.write(",");
				fstream.write(lastName);
				fstream.write(",");
				fstream.write(program);
				fstream.write(",");
				fstream.write(level);
				fstream.write(",");
				fstream.write(username);
				fstream.write(",");
				fstream.write(min);
				fstream.write(System.lineSeparator());
		    }
		}
		
		catch (IOException e) {
		    System.err.println("Error: " + e.getMessage());
		}
		/*
		 *  Closes the file and flushes the buffer of any remaining instructions to print
		 */
		finally
		{
			try {
				fstream.flush();
				fstream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    fstream = null;
            System.gc();
		}
	}
}
