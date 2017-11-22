/*
 * 		Name: Ramirez, Cesar
 * 		Project: #3
 * 		Due: 11/22/17
 * 		Course: cs-240-01-f17
 * 
 * 		Description: To create our own Stack ADT, and to implement that interface with java class Expression.
 * 		The Expression class has two primary behaviors: convertPostFix() and evaluatePostFix().
 * 
 */
public class Expression{
	
	public String[] convertToPostfix(String[] infixExpression){
		String[] postfixExpression = new String[50];
		int top = -1;
		Stack operators = new Stack();
		for(int i = 0; i < infixExpression.length; i++){
			if(infixExpression[i] == null){
				break;
			}
			if(checkOperand(infixExpression[i])){
				postfixExpression[++top] = infixExpression[i];
			}
			else{
				while(!operators.isEmpty() && prec(operators.peek().toString()) > prec(infixExpression[i])){
					postfixExpression[++top] = operators.pop().toString();
				}
				operators.push(infixExpression[i]);
			}
		}
		while(!operators.isEmpty()){
			postfixExpression[++top] = operators.pop().toString();
		}
		return postfixExpression;
	}
	
	public int evaluatePostfix(String[] postfixExpression){
		int result;
		Stack operands = new Stack();
		for(int i = 0; i < postfixExpression.length; i++){
			if(postfixExpression[i] == null){
				break;
			}
			if(checkOperand(postfixExpression[i])){
				operands.push(postfixExpression[i]);
			}
			else{
				if(!operands.isEmpty()){
					int top = Integer.valueOf(operands.pop().toString());
					int next = Integer.valueOf(operands.peek().toString());
					switch(prec(postfixExpression[i])){
						case '1': operands.push(next-top);
						break;
						case '2': operands.push(next+top);
						break;
						case '3': operands.push(next/top);
						break;
						case '4': operands.push(next*top);
						break;
						case '5': operands.push(next^top);
						break;
					}
				}
				else{
					throw new IllegalStateException("Invalid postfix Expression");
				}
			}
		}
		result = Integer.valueOf(operands.pop().toString());
		return result;
	}
	
	private boolean checkOperand(String num){
		char op = num.charAt(0);
		return (op >= '0' && op <= '9');
	}
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
		default: 
			throw new IllegalStateException("Invalid operator! Expression is not acceptable." + num);
		}
		return value;
	}
}