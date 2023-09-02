
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*Eric Gutierrez
 * 4/4/2023
 * Description: Program reads input sequences of characters from a file.
 * The sequences represents infix expressions involving operators +,-,* and / (binary operators), as well as
 * parenthesis(single digit operands).The output is the equivalent postfix expressions and the values of 
 * the expressions 
 */
public class InfixToPostfix {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// Create a Scanner object to read input from file
		Scanner input = new Scanner(new File("lab3.txt"));
		PrintWriter outFile = new PrintWriter(new FileWriter("output.txt"));

		//Creates a object OperatorStack and OperandStack
		//OperandStack pushes ; into the operator stack
		OperatorStack operatorStack =  new OperatorStack();
		operatorStack.push(';');
		OperandStack operandStack = new OperandStack();

		//initialization of variables 
		char operator = ' ';
		int operand;
		// Loop through input file until the end
		while (input.hasNextLine()) {

			int result = 0;
			//used to store the expression
			String temp = input.nextLine();
			//breaking the expression into tokens 
			for(int i =0; i<temp.length();i++) {
				char token = temp.charAt(i);

				if(Character.isDigit(token)) {

					//print the token followed by a space 
					outFile.print(token + " ");
					//push the operand onto the operand stack
					operandStack.push(Integer.parseInt(String.valueOf(token)));

					//else if the token ')' then
				}else if(token ==')') {
					//while the top of the operator stack is not equal '('
					while(operatorStack.peek()!= '(') {
						//pop the operator stack
						//print the operator followed by the space 
						outFile.print(operatorStack.peek()+ " ");
						operator = operatorStack.pop();

						//pop the operand stack twice
						int secondOperand =operandStack.pop();
						int firstOperand= operandStack.pop();

						//apply the designated operation to the two operands 
						//push the operation result onto the operand stack
						if(operator == '+' ){
							result =(firstOperand+secondOperand);
							operandStack.push(result);

						}else if (operator == '-') {
							result = firstOperand-secondOperand;
							operandStack.push(result);

						}else if (operator == '*') {
							result = firstOperand*secondOperand;
							operandStack.push(result);
						}else {
							result = firstOperand/secondOperand;
							operandStack.push(result);
						}



					}//end while 
					//pop the '(' and discard it 
					operator = operatorStack.pop();
				}
				else {
					//while inputPriority((char) token) <= stackPriority(operatorStack.peek())
					while (inputPriority((char) token) <= stackPriority(operatorStack.peek())){

						//pop the operator stack 
						//print the operator followed by a space 
						outFile.print(operatorStack.peek()+ " ");
						operator=operatorStack.pop();

						//pop the operand stack twice 
						//apply the designated operation to the two operand 
						int secondOperand =operandStack.pop();
						int firstOperand= operandStack.pop();


						if(operator == '+' ){
							result =(firstOperand+secondOperand);
							operandStack.push(result);

						}else if (operator == '-') {
							result = firstOperand-secondOperand;
							operandStack.push(result);

						}else if (operator == '*') {
							result = firstOperand*secondOperand;
							operandStack.push(result);
						}else {
							result = firstOperand/secondOperand;
							operandStack.push(result);
						}

					}//end while
					//push the token into the operator stack
					operatorStack.push((char) token);

					/*Get the next token????*/
				}

				//whilte the top of the operator stack is not equal ;
			}
			while(operatorStack.peek()!= ';') {


				//pop the operator stack 
				//print the operator followed by a space 

				outFile.print(operatorStack.peek() + " ");
				operator = operatorStack.pop();


				//pop the operand stack twice
				//Apply the designated operation to the two operands 
				//push the operations result onto the operand stack 
				int secondOperand =operandStack.pop();
				int firstOperand= operandStack.pop();
				//System.out.println(firstOperand);
				//System.out.println(secondOperand);

				if(operator == '+' ){
					result =(firstOperand+secondOperand);
					operandStack.push(result);

				}
				if (operator == '-') {
					result = firstOperand-secondOperand;
					operandStack.push(result);

				}
				if (operator == '*') {
					result = firstOperand*secondOperand;
					operandStack.push(result);
				}
				if(operator == '/'){
					result = firstOperand/secondOperand;
					operandStack.push(result);
				}


			}//end while

			//pop the operand stack, print an "=" sign followed by a space and then print the result 

			outFile.print(" = "+ operandStack.pop());
			outFile.print("\n");


		}
		//end while
		//close input and outfile
		input.close();
		outFile.close();

	}








	//Takes char token(individual element from the expression) and returns the the input priority 
	//value based on the token
	public static int inputPriority(char token) {
		switch(token) {
		case '+':
		case '-':
			return 2 ;
		case '*':
		case '/':
			return 3;
		case '(':
			return 4;
		default:
			return -1;
		}
	}
	//Takes char token(individual element from the expression) and returns the stack  priority 
	//value based on the token
	public static int stackPriority(char token) {
		switch(token) {
		case ';':
			return 0;
		case '+':
		case '-':
			return 2 ;
		case '*':
		case '/':
			return 3;
		case '(':
			return 1;
		default:
			return -1;
		}
	}
}

//stack interface <Type> serves as a placeholder to constrain the the type of elements in the StackInterface.
//The specific data type will be determined when an instance of the stack is created.
//The set of methods in the interface do not have to be declared , in order words 
// the method body is empty 
interface StackInterface <Type>{
	void push(Type item);
	Type pop();
	Type peek();
	boolean isEmpty();

}

//The OperatorStack implements StackInterface, meaning the set of methods in the interface 
//need to be used here, those methods include push(),pop(),pee(),isEmpty().
//Another way to think about this is this is a contract between the interface and this class
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

//The OperandStack implements StackInterface, meaning the set of methods in the interface 
//need to be used here, those methods include push(),pop(),peek(),isEmpty().
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




