/**
 * The IntNode class represents a single node in a linked list, used for storing an integer value.
 * Each node contains an integer operand and a reference to the next IntNode in the list. This class
 * is typically used to create and manage a linked list structure for integer values.
 */
class IntNode{

	//Data fields
	private int operand;
	private IntNode next;

	/*Creates a IntNode with int operand*/
	public IntNode(int operand) {
		this.operand = operand ;
	}

	/*Gets the operand 
	 * returns operand
	 */
	public int getOperand() {
		return operand;

	}

	/*Gets next
	 * return next 
	 */
	public IntNode getNext() {
		return next;
	}

	/*Sets next
	 * @param next
	 */
	public void setNext(IntNode next) {
		this.next = next;
	}

	/*Sets the operand
	 * @param operand
	 */
	public void setOperand(int operand) {
		this.operand = operand;
	}
}