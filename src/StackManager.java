
/**
 * @author Timothy McWatters
 * @version 1.0
 * 
 * COP 4027 Advanced Computer Programming
 * Project 2
 * File Name: StackManager.java
 * 
 * This Program: Will add and subtract arbitrarily large numbers. When the program starts it 
 * will read in a set of addition and subtraction problems consisting of arbitrarily large integers, 
 * solve these problems, and then display the resultant problem and answer on the display.
 */

public class StackManager {
	private Node top = null;
	
	/**
	 * Pushes a Character on to the stack
	 * @param characterToPushOnStack
	 */
	public void push(Character characterToPushOnStack) {
	    Node tmp = new Node();
	    tmp.setData(characterToPushOnStack);
	    tmp.setNextNode(top);
	    top = tmp;
	}
	
	/**
	 * Pops a Character off the stack and returns it
	 * @return Character from the stack
	 */
	public Character pop() {
	    char data = top.getData();
	    top = top.getNextNode();
	    return data;
	}
	
	/**
	 * Determines if the LinkedList is empty
	 * @return true if empty
	 */
	public boolean isEmpty() {
		return top == null;
	}
}
