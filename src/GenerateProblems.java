import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author Timothy McWatters
 * @version 1.0
 * 
 * COP 4027 Advanced Computer Programming
 * Project 2
 * File Name: GenerateProblems.java
 * 
 * This Program: Will add and subtract arbitrarily large numbers. When the program starts it 
 * will read in a set of addition and subtraction problems consisting of arbitrarily large integers, 
 * solve these problems, and then display the resultant problem and answer on the display.
 */

public class GenerateProblems {
	public static final int numTokensPerProblem = 3;
	public static final int maxTokensPerOperandWithSign = 2; //might only be 1 if the Operand is positive with no sign.
	private static ArrayList<Problem> collectionOfProblems = null;
	
	/**
	 * Generic constructor for the GenerateProblems class
	 */
	public GenerateProblems() {
		collectionOfProblems = new ArrayList<Problem>();
	}

	/**
	 * Populates a list of problems
	 */
	public void populateProblemList() {
		for (int i = 0; i < FileOperations.getLinesFromInputFile().size(); i++) {
			Problem problem = createNewProblem(FileOperations.getLinesFromInputFile(i));
			collectionOfProblems.add(problem);
		}
	}
	 
	/**
	 * Creates a new problem from a string read in from the file
	 * @param problemString = string representation of a Problem passed in
	 *  from a line in the file
	 * @return a Problem
	 */
	private Problem createNewProblem(String problemString) {
		String[] tokens = delimitString(problemString);
		
		String firstOpSign = getOperandSign(tokens[0]);
		String firstOperandNoBuffers = getOperand(tokens[0]);
		
		String operator = tokens[1];
		
		String secondOpSign = getOperandSign(tokens[2]);
		String secondOperandNoBuffers = getOperand(tokens[2]);
		
		boolean firstOperandIsBigger = compareOperandSize(firstOperandNoBuffers, secondOperandNoBuffers);
		
		Problem problem = new Problem(firstOperandNoBuffers, firstOpSign, secondOperandNoBuffers, secondOpSign, operator, firstOperandIsBigger);
		Problem problemWithBuffers = addBuffers(problem);
		return problemWithBuffers;
	}
	
	/**
	 * Takes a String and returns an array of Strings delimited by " ";
	 * @param stringToDelimit
	 * @return a String array of tokens delimited by " ";
	 */
	private String[] delimitString(String stringToDelimit) {
		int i = 0;
		String[] tokenArray = new String[numTokensPerProblem];
		StringTokenizer tokens = new StringTokenizer(stringToDelimit);
		while (tokens.hasMoreTokens()) {
			tokenArray[i++] = tokens.nextToken();
		}
		return tokenArray;
	}
	
	/**
	 * Buffers a Problem's operands with 0's
	 * @param problemToAddBuffersTo = this is the problem w/out buffers to the operands
	 * @return the problem with buffers added to the operands
	 */
	private Problem addBuffers(Problem problemToAddBuffersTo) {
		String firstOperand = problemToAddBuffersTo.getFirstOperand();
		String secondOperand = problemToAddBuffersTo.getSecondOperand();
		
		if (problemToAddBuffersTo.isFirstOperandIsBigger() == true) {
			firstOperand = ("0" + firstOperand);
			while (firstOperand.length() != secondOperand.length()) {
				secondOperand = ("0" + secondOperand);
			}
		} else {
			secondOperand = ("0" + secondOperand);
			while (secondOperand.length() != firstOperand.length()) {
				firstOperand = ("0" + firstOperand);
			}
		}
		problemToAddBuffersTo.setFirstOperand(firstOperand);
		problemToAddBuffersTo.setSecondOperand(secondOperand);
		return problemToAddBuffersTo;
	}
	
	/**
	 * Separates the operand from the sign, and returns the sign.
	 * @param stringToGetSignFrom
	 * @return the sign without the operand
	 */
	private String getOperandSign(String stringToGetSignFrom) {
		String firstChar = stringToGetSignFrom.substring(0, 1);
		if (firstChar.equalsIgnoreCase("+")) {
			return "+";
		}
		else if (firstChar.equalsIgnoreCase("-")) {
			return "-";
		}
		else {
			return "+";
		}
	}
	
	/**
	 * Separates the operand from the sign, and returns the operand.
	 * @param stringToGetOperandFrom
	 * @return the operand without the sign
	 */
	private String getOperand(String stringToGetOperandFrom) {
		String firstChar = stringToGetOperandFrom.substring(0, 1);
		if (firstChar.equalsIgnoreCase("+")) {
			return stringToGetOperandFrom.substring(1, stringToGetOperandFrom.length());
		}
		else if (firstChar.equalsIgnoreCase("-")) {
			return stringToGetOperandFrom.substring(1, stringToGetOperandFrom.length());
		}
		else {
			return stringToGetOperandFrom;
		}
	}
	
	/**
	 * Compares the two numbers and if the first number is larger it returns true, else false
	 * @param firstStringToCompare
	 * @param secondStringToCompare
	 * @return boolean representation of if the first number is larger
	 */
	private boolean compareOperandSize(String firstStringToCompare, String secondStringToCompare) {
		if (firstStringToCompare.length() > secondStringToCompare.length()) {
			return true;
		}
		else if (firstStringToCompare.length() == secondStringToCompare.length()) {
				if (firstStringToCompare.compareTo(secondStringToCompare) > 0) {
					return true;
				}
				else {
					return false;
				}
		}
		else {
			return false;
		}
	}
	
	public static ArrayList<Problem> getCollectionOfProblems() {
		return collectionOfProblems;
	}
}
