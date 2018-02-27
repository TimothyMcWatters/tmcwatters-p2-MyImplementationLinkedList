
/**
 * @author Timothy McWatters
 * @version 1.0
 * 
 * COP 4027 Advanced Computer Programming
 * Project 2
 * File Name: ArithmeticOperations.java
 * 
 * This Program: Will add and subtract arbitrarily large numbers. When the program starts it 
 * will read in a set of addition and subtraction problems consisting of arbitrarily large integers, 
 * solve these problems, and then display the resultant problem and answer on the display.
 */

public class ArithmeticOperations {
	//Flags for the add or subtract operations on Characters
	//Corrects the next Character in the stack based on the previous Character's result
	private boolean carryFlag = false;
	private boolean borrowFlag = false;
	
	/**
	 * Coordinates the problem solving efforts for a Problem and provides for a public interface to the Class
	 * @param problemToSolve
	 * @return solution to the Problem in String form
	 */
	public void solveProblem(Problem problemToSolve) {
		//Solves the Problem (step passes Problem to the helper method (determining algorithm))
		String solution = determineOperation(problemToSolve);
		//Sets the solution to the solution calculated by this class
		problemToSolve.setSolution(solution);
	}
	
	/**
	 * Determines if subtractOperation() or addOperation() method gets called based on the Problem set up
	 * @param problemToDetermineOperationOf
	 * @return solution to the problem in String form
	 */
	private String determineOperation(Problem problemToDetermineOperationOf) {
		String solution = "";
		String firstOpSign = problemToDetermineOperationOf.getFirstOperandSign();
		String secondOpSign = problemToDetermineOperationOf.getSecondOperandSign();
		String operator = problemToDetermineOperationOf.getOperator();
		
		//Determines how to solve the Problem based on Operand Signs, and the Operator
		if (operator.equalsIgnoreCase("+")) {
			if (firstOpSign.equalsIgnoreCase("+") && secondOpSign.equalsIgnoreCase("+")) {
				solution = addOperation(problemToDetermineOperationOf);
			}
			else if (firstOpSign.equalsIgnoreCase("-") && secondOpSign.equalsIgnoreCase("-")) {
				solution = "-" + addOperation(problemToDetermineOperationOf);
			} else {
				solution = subtractOperation(problemToDetermineOperationOf);
			}
		}
		if (operator.equalsIgnoreCase("-")) {
			if (firstOpSign.equalsIgnoreCase("+") && secondOpSign.equalsIgnoreCase("+")) {
				solution = subtractOperation(problemToDetermineOperationOf);
			}
			else if (firstOpSign.equalsIgnoreCase("-") && secondOpSign.equalsIgnoreCase("-")) {
				solution = subtractOperation(problemToDetermineOperationOf);
			} else if (firstOpSign.equalsIgnoreCase("+") && secondOpSign.equalsIgnoreCase("-")) {
				solution = addOperation(problemToDetermineOperationOf);
			} else {
				solution = "-" + addOperation(problemToDetermineOperationOf);
			}
		}
		return solution;
	}
	
	/**
	 * performs the addition on a problem by using a StackManager and calling the helper add() method
	 * @param problemToPerformAddOpOn
	 * @return the solution in String form
	 */
	private String addOperation(Problem problemToPerformAddOpOn) {
		String solution = "";
		StackManager firstOpStack = new StackManager();
		StackManager secondOpStack = new StackManager();
		StackManager resultStack = new StackManager();
		
		//Populates the 2 operand stacks
		String firstOp = problemToPerformAddOpOn.getFirstOperand();
		for (int i = 0; i < firstOp.length(); i++) {
			firstOpStack.push(firstOp.charAt(i));
		}
		String secondOp = problemToPerformAddOpOn.getSecondOperand();
		for (int i = 0; i < secondOp.length(); i++) {
			secondOpStack.push(secondOp.charAt(i));
		}

		//Populates the Solution stack with results from add
		while (!firstOpStack.isEmpty()) {
			resultStack.push(add(firstOpStack.pop(), secondOpStack.pop()));
		}

		//Builds a solution string based on the solution stack
		while (!resultStack.isEmpty()) {
			solution += resultStack.pop();
		}
		return solution;
	}
	
	/**
	 * performs the subtraction on a problem by using a StackManager and calling the helper subtract() method
	 * @param problemToPerformSubtractOpOn
	 * @return the solution in String form
	 */
	private String subtractOperation(Problem problemToPerformSubtractOpOn) {
		String solution = "";
		Boolean firstOpIsBigger = problemToPerformSubtractOpOn.isFirstOperandIsBigger();
		String firstOpSign = problemToPerformSubtractOpOn.getFirstOperandSign();
		String secondOpSign = problemToPerformSubtractOpOn.getSecondOperandSign();
		String operator = problemToPerformSubtractOpOn.getOperator();
		StackManager firstOpStack = new StackManager();
		StackManager secondOpStack = new StackManager();
		StackManager resultStack = new StackManager();
		
		//Populates the 2 operand stacks
		String firstOp = problemToPerformSubtractOpOn.getFirstOperand();
		for (int i = 0; i < firstOp.length(); i++) {
			firstOpStack.push(firstOp.charAt(i));
		}
		String secondOp = problemToPerformSubtractOpOn.getSecondOperand();
		for (int i = 0; i < secondOp.length(); i++) {
			secondOpStack.push(secondOp.charAt(i));
		}
		
		//Determines the best order to subtract based off of Signs, Operator, and size of first Operand verses the Second
		//Populates the Solution stack with results from subtract
		//Builds a solution string based on the solution stack
		if (firstOpIsBigger) {
			if ((firstOpSign.equalsIgnoreCase("+") && secondOpSign.equalsIgnoreCase("+") && operator.equalsIgnoreCase("-")) ||
					(firstOpSign.equalsIgnoreCase("+") && secondOpSign.equalsIgnoreCase("-") && operator.equalsIgnoreCase("+"))) {
				while (!firstOpStack.isEmpty()) {
					resultStack.push(subtract(firstOpStack.pop(), secondOpStack.pop()));
				}
				while (!resultStack.isEmpty()) {
					solution += resultStack.pop();
				}
				return solution;
			} else {
				while (!firstOpStack.isEmpty()) {
					resultStack.push(subtract(firstOpStack.pop(), secondOpStack.pop()));
				}
				while (!resultStack.isEmpty()) {
					solution += resultStack.pop();
				}
				return "-" + solution;
			}
		} else {
			if ((firstOpSign.equalsIgnoreCase("+") && secondOpSign.equalsIgnoreCase("+") && operator.equalsIgnoreCase("-")) ||
					(firstOpSign.equalsIgnoreCase("+") && secondOpSign.equalsIgnoreCase("-") && operator.equalsIgnoreCase("+"))) {
				while (!firstOpStack.isEmpty()) {
					resultStack.push(subtract(secondOpStack.pop(), firstOpStack.pop()));
				}
				while (!resultStack.isEmpty()) {
					solution += resultStack.pop();
				}
				return "-" + solution;
			} else {
				while (!firstOpStack.isEmpty()) {
					resultStack.push(subtract(secondOpStack.pop(), firstOpStack.pop()));
				}
				while (!resultStack.isEmpty()) {
					solution += resultStack.pop();
				}
				return solution;
			}
		}
	}
	
	/**
	 * Performs addition on two character representations of int's
	 * will return the last digit of the result, and if result is > 9 will update carryFlag to true
	 * @param firstCharacterToAdd
	 * @param secondCharacterToAdd
	 * @return a character representation of the last digit of the addition performed
	 */
	private Character add(Character firstCharacterToAdd, Character secondCharacterToAdd) {
		//Determines if the previous step had a carry that needs to be handled in this step
		int carry = 0;
		if (this.carryFlag == true) {
			carry = 1;
		} else {
			carry = 0;
		}
		this.carryFlag = false;
		int addResult = Integer.parseInt(firstCharacterToAdd.toString()) + Integer.parseInt(secondCharacterToAdd.toString()) + carry;
		
		//Performs the Arithmetic on the two Characters
		if (addResult > 9) {
			this.carryFlag = true;
			int lastDigit = (addResult - 10);
			char[] convertedAddResult = Character.toChars('0' + lastDigit);
			return convertedAddResult[0];
		} else {
			char[] convertedAddResult = Character.toChars('0' + addResult);
			return convertedAddResult[0];
		}
	}
	
	/**
	 * Performs subtraction actions on two Characters by converting them to ints and back to Characters
	 * @param firstCharacterToSubtract
	 * @param secondCharacterToSubtract
	 * @return the result of the subtraction
	 */
	private Character subtract(Character firstCharacterToSubtract, Character secondCharacterToSubtract) {
		Integer intFirstCharacterToSubtract = Integer.parseInt(firstCharacterToSubtract.toString());
		Integer intSecondCharacterToSubtract = Integer.parseInt(secondCharacterToSubtract.toString());
		
		//Determines if we borrowed from this Character in the previous step
		if(this.borrowFlag == true) {
			intFirstCharacterToSubtract -= 1;
			this.borrowFlag = false;
		} 
		
		//Determines if we need to borrow from the next Character to complete this step
		if (intFirstCharacterToSubtract.compareTo(intSecondCharacterToSubtract) < 0) {
			intFirstCharacterToSubtract += 10;
			this.borrowFlag = true;
		}
		
		//Performs the Arithmetic operation on these two Characters
		int subtractResult = intFirstCharacterToSubtract - intSecondCharacterToSubtract;
		char[] convertedSubtractResult = Character.toChars('0' + subtractResult);
		return convertedSubtractResult[0];
	}
}
