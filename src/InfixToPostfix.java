/*Eric Gutierrez
 * 4/4/2023
 * Description: Program reads input sequences of characters from a file.
 * The sequences represents infix expressions involving operators +,-,* and / (binary operators), as well as
 * parenthesis(single digit operands).The output is the equivalent postfix expressions and the values of 
 * the expressions 
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


 /**
 * The InfixToPostfix class converts infix expressions to postfix expressions and evaluates them.
 * It reads infix expressions from a file, processes each expression, and outputs the equivalent
 * postfix expression along with its evaluated result to an output file.
 */
public class InfixToPostfix {

	/**
 * The main method reads input sequences of characters (infix expressions) from a file,
 * converts them to postfix expressions, evaluates them, and writes the results to an output file.
 * @param args Command line arguments (not used in this program).
 * @throws IOException If an I/O error occurs.
 */
	public static void main(String[] args) throws IOException {
	
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