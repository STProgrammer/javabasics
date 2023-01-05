import java.util.Deque;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.util.Scanner;


public class PostfixNotation {
	
	private static Deque<Integer> operandStack = new ArrayDeque<>();
	static StringTokenizer tokens;
	private static boolean validExpression = true;
	private static boolean divideByZero = false;
	
	
	/** evaluate the expression, could make it return array or String but
	 * the assignment requires it to return integer */
	public static int evaluateExpression(String expression) {
		operandStack.clear(); // delete all in stack if any left
		validExpression = true; //set it to true if it was false
		divideByZero = false; //set it to false if it was true
	
		if (expression.isBlank() || !expression.matches("[-0-9+*/ ]+")) {
			return 0;
		}
			
		tokens = new StringTokenizer(expression, " +-*/", true);
		
		validExpression = scanAndProcessTokens();
		
		if (divideByZero || !validExpression) {
			return 0;
		}		
		return (operandStack.pop()).intValue();
	}
	
	/** scan and process the tokens */
	private static boolean scanAndProcessTokens() {
		  while (tokens.hasMoreTokens()) {
		    String token = tokens.nextToken().trim();
		    if (token.length() == 0)
		      continue;
		    else if (token.charAt(0) == '+' ||
		    		token.charAt(0) == '-' ||
		    		token.charAt(0) == '*' ||
		    		token.charAt(0) == '/') {
		    	/**Needs at least two operands before an operator
		    	 * e.g. "3 +" is invalid, so is "3 4 + +" invalid*/
		    	if (operandStack.size() < 2) {
		    		return false;
		    	}
		    	processAnOperator(token.charAt(0));
		    }
		    else {
		    	operandStack.push(Integer.valueOf(token));
		    }
		  } // end while (tokens.hasMoreTokens) loop
		  /** Check if not any operands left on stack
		   * e.g. "1 2 3 +" is invalid as 1 is not operated on */
		  if ((operandStack.size() > 1)) {
			  return false;
		  }
		  return true;
		}
	
	/**process an operator */
	private static boolean processAnOperator(char op) {
		int num = 0;
		if (op == '+') {
			num = operandStack.pop() + operandStack.pop();
			operandStack.push(num);
		}
		else if (op == '-') {
			num = operandStack.pop();
			int num2 = operandStack.pop();
			operandStack.push(num2 - num);
		}
		else if (op == '*') {
			num = operandStack.pop() * operandStack.pop();
			operandStack.push(num);
		}
		else if (op == '/') {
			num = operandStack.pop();
			if (num == 0) {
				divideByZero = true;
				num++;  /**Only to make sure the operations continue and we don't get 
				"invalid expression" error when the expression is actually valid */
			} else {
				int num2 = operandStack.pop();
				operandStack.push(num2 / num);
			}
		}
		return true;
	}
	
	/**Check if the expression is valid and return the result as String */
	public static String printResult(String expression) {
		if (expression.isBlank()) {
			return (" ");
		}
		
		else if (!expression.matches("[-0-9+*/ ]+")) {
			return ("Invalid characters!");
		}

		int result = evaluateExpression(expression);
		
		if (divideByZero) {
			return ("Undefined (can't divide by zero)!");
		}
		else if (!validExpression) {
			return ("Invalid expression!");
		}
		else return Integer.toString(result);
	}
	
	/**MAIN METHOD */
	public static void main (String args[]) {
		Scanner input = new Scanner(System.in);
		String expr = new String();
		System.out.println("Postfix notation calculator. Enter \"q\" to quit");
		expr = input.nextLine();
		while (!expr.equals("q")) {
			System.out.println(PostfixNotation.printResult(expr));
			System.out.println("Enter postfix notation (enter \"q\" to quit): ");
			expr = input.nextLine();	
		}
		input.close();
	}

}
