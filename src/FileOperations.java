import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Timothy McWatters
 * @version 1.0
 * 
 * COP 4027 Advanced Computer Programming
 * Project 2
 * File Name: FileOperations.java
 * 
 * This Program: Will add and subtract arbitrarily large numbers. When the program starts it 
 * will read in a set of addition and subtraction problems consisting of arbitrarily large integers, 
 * solve these problems, and then display the resultant problem and answer on the display.
 */

public class FileOperations {
	private Scanner inputStream = null;
	private static ArrayList<String> linesFromInputFile = null;
	
	/**
	 * Default constructor for the FileOperations class
	 */
	public FileOperations() {
		linesFromInputFile = new ArrayList<String>();
	}

	/**
	 * Getter for the linesFromInputFile ArrayList<String>
	 * @return the linesFromInputFile
	 */
	public static ArrayList<String> getLinesFromInputFile() {
		return linesFromInputFile;
	}

	/**
	 * Reads a file line by line, and calls the helper method populateLinesArrayList to populate an ArrayList
	 * with each line read in from the file.
	 * @param fileName = name of the file to read
	 */
	public void readFile(String fileName) {
		try {
			inputStream = new Scanner(new FileInputStream(fileName));
		}
		catch (FileNotFoundException e) {
			System.out.println("Error: File " + fileName + " was not found, or could not be opened.");
			System.exit(0);
		}
		while (inputStream.hasNextLine()) {
			populateLinesArrayList(inputStream.nextLine());
		} 
		inputStream.close();
	}
	
	/**
	 * Populates an ArrayList with Strings
	 * @param lineFromFile = The string to populate the ArrayList with
	 */
	private static void populateLinesArrayList(String lineFromFile) {
		linesFromInputFile.add(lineFromFile);
	}
	
	/**
	 * Will return the String located at the index parameter from the 
	 * ArrayList<String> of Strings read in from the file. 
	 * @param indexOfArrayList = index of ArrayList<String> that is requested to be returned
	 * @return lineFromInputFile = The line of the input file that has been stored in the
	 * ArrayList<String>
	 */
	public static String getLinesFromInputFile(int indexOfArrayList) {
		return linesFromInputFile.get(indexOfArrayList);
	}
	
}
