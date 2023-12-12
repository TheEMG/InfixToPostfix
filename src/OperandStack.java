

/**
 * The OperandStack class implements the StackInterface for Integer values.
 * It provides the basic stack operations such as push, pop, peek, and isEmpty.
 * This class uses a linked list structure, with each node in the list representing
 * an element in the stack. The top of the stack is maintained by the 'top' pointer.
 * The methods of the interface MUST BE USED HERE 
 */
class OperandStack implements StackInterface<Integer>{

	//Data Member
	private IntNode top;

	//top, the pointer , initialized to null
	public OperandStack() {
		top = null;
	}

	//This will make the item(parameter) be on the top of the stack 
	public void push(Integer item) {
		IntNode newNode = new IntNode(item);
		newNode.setNext(top);
		top = newNode;
	}

	//Deletes the the top of the stack after its been returned
	public Integer pop() {
		if(isEmpty()) {
			return null;
		}
		Integer item = top.getOperand();
		top = top.getNext();
		return item ;
	}


	//gets the top of the operator stack But does not delete it. 
	public Integer peek() {
		if(isEmpty()) {
			return null;
		}
		return top.getOperand();
	}

	//if the stack is empty then return the top as null 
	public boolean isEmpty() {
		return top == null;
	}
}