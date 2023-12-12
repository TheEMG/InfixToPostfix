
/**
 * The StackInterface is a generic interface defining the fundamental operations of a stack.
 * It uses a generic type <Type> to allow for flexibility in the type of elements the implementing
 * stack can hold. This interface ensures that any class implementing it will have the core stack
 * operations: push, pop, peek, and isEmpty.
 * The set of methods in the interface do not have to declared (method body is empty)
 *
 * @param <Type> The type of elements held in the stack. This generic type allows the stack to be 
 *               used with any object type.
 */
interface StackInterface <Type>{
	void push(Type item);
	Type pop();
	Type peek();
	boolean isEmpty();

}