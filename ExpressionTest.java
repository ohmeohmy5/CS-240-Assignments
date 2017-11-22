import java.util.Arrays;

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
public class ExpressionTest {
	
	public static void main(String args[]){
		
		System.out.println("convertToPostfix() testing:");
		System.out.println("");
		
		Expression example = new Expression();
		String[] a = new String[7];
		a[0] = "(";
		a[1] = "8";
		a[2] = "+";
		a[3] = "4";
		a[4] = ")";
		a[5] = "*";
		a[6] = "7";
		System.out.println("Orignal infix expression:" + Arrays.toString(a));
		System.out.println(Arrays.toString(example.convertToPostfix(a)));
		System.out.println("Working addition expression with parentheses");
		
		System.out.println("");
		System.out.println("The next 4 following parentheses tests are done so with otherwise valid expressions:");
		
		System.out.println("");
		String[] b = new String[4];
		b[0] = "(";
		b[1] = "8";
		b[2] = "+";
		b[3] = "4";
		try{
		System.out.println(Arrays.toString(example.convertToPostfix(b)));
		} 
		catch(IllegalArgumentException exception){
			System.out.println("Program is able to catch a lack of ending parentheses");
		}
		
		String[] c = new String[6];
		c[0] = "(";
		c[1] = "(";
		c[2] = "4";
		c[3] = "+";
		c[4] = "5";
		c[5] = ")";
		try{
			System.out.println(Arrays.toString(example.convertToPostfix(c)));
		} 
		catch(IllegalArgumentException exception){
			System.out.println("Program is able to catch a use of multiple opening parentheses before a close");
		}
		
		System.out.println("");
		String[] d = new String[5];
		d[0] = "(";
		d[1] = ")";
		d[2] = "4";
		d[3] = "+";
		d[4] = "5";
		try{
			System.out.println("Orignal infix expression:" + Arrays.toString(d));
			System.out.println(Arrays.toString(example.convertToPostfix(d)));
			System.out.println("Program ignores a parentheses open and close with no operands/operators in between");
		} 
		catch(IllegalArgumentException exception){
		}
		
		String[] e = new String[4];
		e[0] = "3";
		e[1] = "+";
		e[2] = "6";
		e[3] = ")";
		try{
			System.out.println(Arrays.toString(example.convertToPostfix(e)));
		} 
		catch(IllegalStateException exception){
			System.out.println("Program can catch a end parentheses with no open. This is due to the fact that the local"
					+ "stack lacks operators when the ) is called");
		}
		
		System.out.println("");
		String[] f = new String[3];
		f[0] = "3";
		f[1] = "*";
		f[2] = "7";
		System.out.println("Orignal infix expression:" + Arrays.toString(f));
		System.out.println(Arrays.toString(example.convertToPostfix(f)));
		System.out.println("Working multiplication expression");
		
		System.out.println("");
		String[] g = new String[7];
		g[0] = "(";
		g[1] = "6";
		g[2] = "-";
		g[3] = "2";
		g[4] = ")";
		g[5] = "/";
		g[6] = "4";
		System.out.println("Orignal infix expression:" + Arrays.toString(g));
		System.out.println(Arrays.toString(example.convertToPostfix(g)));
		System.out.println("Working division/subtraction expression, with parentheses");
		
		System.out.println("");
		String[] h = new String[5];
		h[0] = "7";
		h[1] = "";
		h[2] = "6";
		h[3] = "*";
		h[4] = "8";
		try{
			System.out.println(Arrays.toString(example.convertToPostfix(h)));
		} 
		catch(IllegalArgumentException exception){
			System.out.println("Program catches the lack of an operator, an empty space, making the argument invalid");
		}
		
		String[] i = new String[5];
		i[0] = "(";
		i[1] = "r";
		i[2] = "*";
		i[3] = "3";
		i[4] = ")";
		try{
			System.out.println(Arrays.toString(example.convertToPostfix(i)));
		} 
		catch(IllegalArgumentException exception){
			System.out.println("Despite valid parenthesis, program catches invalid operand");
		}
		
		String[] j = new String[5];
		j[0] = "(";
		j[1] = "(";
		j[2] = "4";
		j[3] = "@";
		j[4] = "3";
		try{
			System.out.println(Arrays.toString(example.convertToPostfix(j)));
		} 
		catch(IllegalArgumentException exception){
			System.out.println("Program catches mismatched parentheses, with invalid operator");
		}
		
		String[] k = new String[5];
		k[0] = "3";
		k[1] = "";
		k[2] = "6";
		k[3] = ")";
		k[4] = ")";
		try{
			System.out.println(Arrays.toString(example.convertToPostfix(k)));
		} 
		catch(IllegalArgumentException exception){
			System.out.println("Program catches the missing operator, with the mismatched parentheses");
		}
		
		System.out.println("");
		System.out.println("evaluatePostfix() testing:");
		
		System.out.println("");
		String[] l = new String[5];
		l[0] = "2";
		l[1] = "8";
		l[2] = "*";
		l[3] = "4";
		l[4] = "/";
		try{
			System.out.println("Should equal 4:");
			System.out.println(example.evaluatePostfix(l));
		} 
		catch(IllegalArgumentException exception){
		}
		
		System.out.println("");
		String[] m = new String[5];
		m[0] = "2";
		m[1] = "3";
		m[2] = "6";
		m[3] = "-";
		m[4] = "+";
		try{
			System.out.println("Should equal -1:");
			System.out.println(example.evaluatePostfix(m));
		} 
		catch(IllegalArgumentException exception){
		}
		
		System.out.println("");
		String[] n = new String[5];
		n[0] = "3";
		n[1] = "-";
		n[2] = "6";
		n[3] = "+";
		n[4] = "7";
		try{
			System.out.println(example.evaluatePostfix(n));
		} 
		catch(IllegalStateException exception){
			System.out.println("Program catches that the input is not a valid postfix expression");
		}
		
		String[] o = new String[5];
		o[0] = "3";
		o[1] = "2";
		o[2] = "5";
		o[3] = "";
		o[4] = "*";
		try{
			System.out.println(example.evaluatePostfix(o));
		} 
		catch(IllegalArgumentException exception){
			System.out.println("Program catches when the postfix expression contains invalid operators/operands.");
		}
		
		String[] p = new String[5];
		p[0] = "%";
		p[1] = "6";
		p[2] = "5";
		p[3] = "-";
		p[4] = "+";
		try{
			System.out.println(example.evaluatePostfix(p));
		} 
		catch(IllegalArgumentException exception){
			System.out.println("Program catches inappropriate form for the postfix expression");
		}
		
		System.out.println("");
		System.out.println("Will now test the both convertToPostfix and evaluatePostfix:");
		
		System.out.println("");
		String[] q = new String[11];
		q[0] = "(";
		q[1] = "5";
		q[2] = "+";
		q[3] = "3";
		q[4] = ")";
		q[5] = "*";
		q[6] = "(";
		q[7] = "4";
		q[8] = "/";
		q[9] = "2";
		q[10] = ")";
		System.out.println("Orignal infix expression:" + Arrays.toString(q));
		System.out.println(Arrays.toString(example.convertToPostfix(q)));
		String[] pq = example.convertToPostfix(q);
		System.out.println("Should be 16:");
		System.out.println(example.evaluatePostfix(pq));
		
		System.out.println("");
		String[] r = new String[5];
		r[0] = "9";
		r[1] = "*";
		r[2] = "8";
		r[3] = "+";
		r[4] = "5";
		System.out.println("Orignal infix expression:" + Arrays.toString(r));
		System.out.println(Arrays.toString(example.convertToPostfix(r)));
		String[] pr = example.convertToPostfix(r);
		System.out.println("Should be 77:");
		System.out.println(example.evaluatePostfix(pr));
	}
}
