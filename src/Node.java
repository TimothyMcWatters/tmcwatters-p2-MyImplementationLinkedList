
/**
 * @author Timothy McWatters
 * @version 1.0
 * 
 * COP 4027 Advanced Computer Programming
 * Project 2
 * File Name: Node.java
 * 
 * This Program: Will add and subtract arbitrarily large numbers. When the program starts it 
 * will read in a set of addition and subtraction problems consisting of arbitrarily large integers, 
 * solve these problems, and then display the resultant problem and answer on the display.
 */

public class Node {
	private Character data = ' ';
	private Node nextNode = null;
	
	/**
	 * Default constructor for the Node class
	 */
	public Node() {
	}
	
	/**
	 * Parameterized constructor for the Node class
	 * @param data
	 * @param nextNode
	 */
	public Node(Character data, Node nextNode) {
		this.data = data;
		this.nextNode = nextNode;
	}

	/**
	 * @return the data
	 */
	public Character getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Character data) {
		this.data = data;
	}

	/**
	 * @return the nextNode
	 */
	public Node getNextNode() {
		return nextNode;
	}

	/**
	 * @param nextNode the nextNode to set
	 */
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	
}
