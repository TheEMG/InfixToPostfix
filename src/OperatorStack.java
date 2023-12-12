/**
 * The OperatorStack class implements a stack for character operators. It uses a linked list 
 * structure, where each node in the list represents an element in the stack. This class provides 
 * standard stack operations such as push, pop, peek, and isEmpty, as defined in the StackInterface.
 * This implementation is particularly suited for handling operators in expressions.
 * Another way to think about the interface, is that its a contract between the interface and this class 
 */
class OperatorStack implements StackInterface<Character>{

	//Data Member
	private CharNode top;

	//top, the pointer , initialized to null
	public OperatorStack() {

		top = null;
	}

	//This will make the item(parameter) be on the top of the stack 
	public void push(Character  item) {
		CharNode newNode =  new CharNode(item);
		newNode.setNext(top);
		top = newNode;

	}

	//Deletes the the top of the stack after its been returned
	public Character pop() {
		if(isEmpty()) {
			return null;
		}
		Character value = top.getOperator();
		top = top.getNext();
		return value;

	}

	//gets the top of the operator stack But does not delete it. 
	public Character peek() {
		if(isEmpty()) {
			return null;
		}
		return top.getOperator();
	}

	//if the stack is empty then return the top as null 
	public boolean isEmpty() {
		return top == null;
	}


}
