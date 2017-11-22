import java.util.Arrays;

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
public class ExpressionTest {
	public static void main(String args[]){
		Expression example = new Expression();
		String[] exp = new String[50];
		exp[0] = "9";
		exp[1] = "3";
		exp[2] = "+";
		exp[3] = "4";
		exp[4] = "*";
		System.out.println("result:" + example.evaluatePostfix(exp));
	}
}
