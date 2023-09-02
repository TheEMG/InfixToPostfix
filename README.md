# InfixToPostfix
 Description: Program reads input sequences of characters from a file.
  The sequences represents infix expressions involving operators +,-,* and / (binary operators), as well as
  parenthesis(single digit operands).The output is the equivalent postfix expressions and the values of 
  the expressions.
  -  A stack data structure is used to assist in converting infix expressions to postfix.
    It is also used to evaluate the postfix expressions.
    The stack helps maintain the order of operators and operands during the conversion and evaluation process.

## What did i learn 
- I learned how to use the "stack" data structure in order to convert infix to postfix
- The stack proved to be effective by keeping the operands and operators within their respective stack
- I learned how the operators are mananged, by using the Shunting Algorithm.The algorithm played an important role when evaluating the postfix expression. This is accomplished by two value-returning methods: inputPriority and stackPriority.
    - inputPriority: Takes a token and returns the priority value of an operator when it is on the input string.
    - stackPriority: Takes the top operator from the stack  returns the priority value of an operator
- An interface was employed (StackInterface) , and apparently you dont need to define the methods within the interface iteself.
  Instead, concrete classes that implement this interface are responsible for supplying the method implementations.
    - A way of thinking of this is a contract between the interface and the class
  





 
