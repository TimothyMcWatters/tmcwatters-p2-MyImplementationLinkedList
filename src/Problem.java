
/**
 * @author Timothy McWatters
 * @version 1.0
 * 
 * COP 4027 Advanced Computer Programming
 * Project 2
 * File Name: Problem.java
 * 
 * This Program: Will add and subtract arbitrarily large numbers. When the program starts it 
 * will read in a set of addition and subtraction problems consisting of arbitrarily large integers, 
 * solve these problems, and then display the resultant problem and answer on the display.
 */

public class Problem {
	private String firstOperand = ""; 
	private String firstOperandSign = "";
	private String secondOperand = "";
	private String secondOperandSign = "";
	private String operator = "";
	private boolean firstOperandIsBigger = false;
	private String solution = "";
	
	/**
	 * @param firstOperand
	 * @param firstOperandSign
	 * @param secondOperand
	 * @param secondOperandSign
	 * @param operator
	 * @param firstOperandIsBigger
	 */
	public Problem(String firstOperand, String firstOperandSign, String secondOperand, String secondOperandSign,
			String operator, boolean firstOperandIsBigger) {
		super();
		this.firstOperand = firstOperand;
		this.firstOperandSign = firstOperandSign;
		this.secondOperand = secondOperand;
		this.secondOperandSign = secondOperandSign;
		this.operator = operator;
		this.firstOperandIsBigger = firstOperandIsBigger;
	}

	/**
	 * @return the firstOperand
	 */
	public String getFirstOperand() {
		return firstOperand;
	}

	/**
	 * @param firstOperand the firstOperand to set
	 */
	public void setFirstOperand(String firstOperand) {
		this.firstOperand = firstOperand;
	}

	/**
	 * @return the firstOperandSign
	 */
	public String getFirstOperandSign() {
		return firstOperandSign;
	}

	/**
	 * @param firstOperandSign the firstOperandSign to set
	 */
	public void setFirstOperandSign(String firstOperandSign) {
		this.firstOperandSign = firstOperandSign;
	}

	/**
	 * @return the secondOperand
	 */
	public String getSecondOperand() {
		return secondOperand;
	}

	/**
	 * @param secondOperand the secondOperand to set
	 */
	public void setSecondOperand(String secondOperand) {
		this.secondOperand = secondOperand;
	}

	/**
	 * @return the secondOperandSign
	 */
	public String getSecondOperandSign() {
		return secondOperandSign;
	}

	/**
	 * @param secondOperandSign the secondOperandSign to set
	 */
	public void setSecondOperandSign(String secondOperandSign) {
		this.secondOperandSign = secondOperandSign;
	}

	/**
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * @param operator the operator to set
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * @return the firstOperandIsBigger
	 */
	public boolean isFirstOperandIsBigger() {
		return firstOperandIsBigger;
	}

	/**
	 * @param firstOperandIsBigger the firstOperandIsBigger to set
	 */
	public void setFirstOperandIsBigger(boolean firstOperandIsBigger) {
		this.firstOperandIsBigger = firstOperandIsBigger;
	}

	/**
	 * @return the solution
	 */
	public String getSolution() {
		return solution;
	}

	/**
	 * @param solution the solution to set
	 */
	public void setSolution(String solution) {
		this.solution = solution;
	}
	
	/**
	 * Formats and returns the String representation of the problem to solve plus solution.
	 * @return problem = the problem to solve w/ solution in a formated String representation
	 */
	public String toString() {
		String firstLine = getFirstOperandSign() + getFirstOperand();
		String secondLine = getOperator() + " " + getSecondOperandSign() + getSecondOperand();
		String thirdLine = "";
		for (int i = 0; i < secondLine.length(); i++) {
			thirdLine += "_";
		}
		String fourthLine = getSolution();
		String problem = "  " + firstLine + "\n" + secondLine + "\n" + thirdLine + "\n" + fourthLine + "\n";
		return problem;
	}
	
	/**
	 * Prints the problem to solve plus solution.
	 */
	public void printProblem() {
		System.out.println(toString());
	}
	
}
