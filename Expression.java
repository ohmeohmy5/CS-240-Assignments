/*
 * 		Name: Ramirez, Cesar
 * 		Project: #3
 * 		Due: 11/22/17
 * 		Course: cs-240-01-f17
 * 
 * 		Description: To create our own generic Stack class, and to use that in java class Expression.
 * 		The Expression class has two primary behaviors: convertPostFix() and evaluatePostFix(). The stack is used
 *      in organizing the operands/operators to acheive the desired effect.
 * 
 */
public class Expression{
	
	// converts given infix expression to a postfix expression. Does so by creating a local variable stack, and using that
	// to store any operators we come across in our iteration through the entire given array. The local variable top will
	// be used to keep track of the size of the array we want to return (number of items). The stack has a capacity of about
	// 50 which should be more than sufficient for the infix expressions. In the for loop throught the given array, we check
	// if the item at the location is an operand using checkOperand(), if so we add it to the String array we want to
	// return, postfixExpression. If not, that means it is an operator, in which case we push it to the local stack.
	// However, depending the value given to us by prec(), the operator must have its priority checked against the operators
	// already in the stack (if any), and it will be placed at the top if it has highest priority. Whenever we have lower
	// priority operator, we pop() from the stack and place the popped operator into the postfixExpression array, until
	// we find a suitable location for our operator to be pushed. The boolean value parentheses is used to check if any
	// parantheses are opened and make sure it is closed, otherwise it will throw exceptions. When ) is found, the
	// operators of the stack are popped and placed into postfixExpression until ( is popped. Once the for loop is over,
	// the stack is popped for any many remaining operators to be placed in the String array. Lastly, the string array is
	// resized using top, eliminating any excess slots that were not used for operands/operators.
	public String[] convertToPostfix(String[] infixExpression){
		String[] postfixExpression = new String[50];
		int top = -1;
		boolean parentheses = false;
		Stack operators = new Stack();
		for(int i = 0; i < infixExpression.length; i++){
			if(infixExpression[i] == null || infixExpression[i].equals("")){
				throw new IllegalArgumentException("Poorly formed infix argument.");
			}
			if(checkOperand(infixExpression[i])){
				postfixExpression[++top] = infixExpression[i];
			}
			else if(infixExpression[i] == "(" && !parentheses){
				parentheses = true;
				operators.push(infixExpression[i]);
			}
			else if(infixExpression[i] == "(" && parentheses){
				throw new IllegalArgumentException("Invalid argument! There is a missing parentheses.");
			}
			else{
				if(infixExpression[i] == ")"){
					while(!operators.isEmpty() && operators.peek().toString() != "("){
						postfixExpression[++top] = operators.pop().toString();
					}
					if(operators.peek().toString() == "("){
						operators.pop();
						parentheses = false;
					}
					else{
						throw new IllegalArgumentException("Invalid argument! There is a missing parentheses.");
					}
				}
				else{
					while(!operators.isEmpty() && prec(operators.peek().toString()) > prec(infixExpression[i])){
						postfixExpression[++top] = operators.pop().toString();
					}
					operators.push(infixExpression[i]);
				}
			}
		}
		while(!operators.isEmpty()){
			postfixExpression[++top] = operators.pop().toString();
		}
		if(parentheses){
			throw new IllegalArgumentException("Invalid argument! There is a missing parentheses.");
		}
		String[] result = new String[top+1];
		for(int i = 0; i < result.length; i++){
			result[i] = postfixExpression[i];
		}
		return result;
	}
	
	// This method serves to return an integer based on solving a postfix expression. This uses a local stack like convert-
	// ToPostfix(), but this time for operands. As we iterate through the given array, we check if the value is an operand,
	// using checkOperand, and push it to the stack. Once we encounter a operator, we should have at least two operands in
	// the stack already, (due to the nature of the postfix) and we use the top two operands of the stack and evaluate them
	// using the given operator. The operator is found using a switch case through prec(), translating the value into the
	// appropriate operator. Once we combine the two operands, the new value is pushed onto the stack. Once the loop finishes,
	// the stack should have one value left, and that is our return integer. We pop it off the stack and return it to the user.
	public int evaluatePostfix(String[] postfixExpression){
		int result;
		Stack operands = new Stack();
		for(int i = 0; i < postfixExpression.length; i++){
			if(postfixExpression[i] == null || postfixExpression[i].equals("")){
				throw new IllegalArgumentException("Invalid postfix input.");
			}
			if(checkOperand(postfixExpression[i])){
				operands.push(postfixExpression[i]);
			}
			else{
				if(!operands.isEmpty()){
					int top = Integer.valueOf(operands.pop().toString());
					int next = Integer.valueOf(operands.peek().toString());
					int sum;
					switch(prec(postfixExpression[i])){
						case 1: sum = next-top;
						break;
						case 2: sum = next+top;
						break;
						case 3: sum = next/top;
						break;
						case 4: sum = next*top;
						break;
						case 5: sum = next^top;
						break;
						default: sum = 0;
					}
					operands.pop();
					operands.push(sum);
				}
				else{
					throw new IllegalArgumentException("Invalid postfix Expression");
				}
			}
		}
		result = Integer.valueOf(operands.pop().toString());
		return result;
	}
	
	// This method serves to check if the String at a given location contains an operand. The string is converted to
	// a char to easily compare to the numbers 0-9, the only valid operands in our implementation
	private boolean checkOperand(String num){
		char op = num.charAt(0);
		return (op >= '0' && op <= '9');
	}
	
	// The purpose of this method is to return integer indicating the priority value of the given String, which should
	// be an operator. Each operator has a corresponding value, regarding their priority over the other operators.
	// This will help us organize the local stack containing our operators in convertToPostfix. Notice that the
	// "(" corresponds to value of 0, this will allow all operators coming after the "(" to be placed in higher priority.
	// Until a ")" is encountered, which the operators that follow the "(" will be placed into the resulting String[]
	// postfix expression
	private int prec(String num){
		int value = 0;
		switch(num){
		case "+": value = 2;
		break;
		case "*": value = 4;
		break;
		case "-": value = 1;
		break;
		case "/": value = 3;
		break;
		case "^": value = 5;
		break;
		case "(": value = 0;
		break;
		case ")":
		break;
		default: 
			throw new IllegalArgumentException("Invalid operator/operand! Expression is not acceptable.");
		}
		return value;
	}
}