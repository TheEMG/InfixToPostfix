
/**
 * The CharNode class represents a single node in a linked list, primarily used for storing a character.
 * This character typically represents an operator in an expression. The class also includes a reference
 * to the next CharNode in the list, allowing for linked list operations.
 */
class CharNode {
	//Data Fields
	private char operator;
	private CharNode next;

	/*Creates a CharNode with char operator */
	public CharNode(char operator) {
		this.operator = operator;
	}

	/*Gets the operator
	 * returns the operator
	 */
	public char getOperator() {
		return operator;
	}

	/*Gets the next CharNode 
	 * returns next
	 */
	public CharNode getNext() {
		return next;
	}

	/*Sets the operator
	 * @param operator
	 */
	public void setOperator(char operator) {
		this.operator = operator;
	}

	/*Sets next
	 * @param next
	 */
	public void setNext(CharNode next) {
		this.next = next;
	}
}