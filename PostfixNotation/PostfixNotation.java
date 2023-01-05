package Modul03;

import java.util.ArrayDeque;

public class PostfixNotation {
    private ArrayDeque<Integer> arrayDeque;
    private java.util.StringTokenizer tokens;

    public PostfixNotation() {
        arrayDeque = new ArrayDeque<>();
    }

    public int evaluateExpression(String expression) {
        if (expression == null || expression.trim().equals("")) {
            throw new IllegalArgumentException("Null or empty string: " + expression);
        }
        if (expression.matches("[0-9+\\-/* ]")) {
            throw new IllegalArgumentException("Expression contains illegal characters: " + expression);
        }
        if (!expression.trim().isEmpty()) {
            tokens = new java.util.StringTokenizer(expression, " +-/*%", true);
            scanAndProcessTokens();
        }

        return arrayDeque.pop();
    }

    private void scanAndProcessTokens() {
        while (tokens.hasMoreTokens()) {
            String token = tokens.nextToken().trim();
            if (token.length() == 0)
                continue;
            else if (token.matches("[+-/*%]"))
                //calculateExpression(token);
                calculateExpression(token);
            else arrayDeque.push(Integer.parseInt(token));
        }
    }

    private void calculateExpression(String operand) {
        if (arrayDeque.size() < 2) {
            throw new IllegalArgumentException("Too many or misplaced operands.");
        }
        int op1 = arrayDeque.pop();
        int op2 = arrayDeque.pop();

        switch (operand) {
            case "+":
                arrayDeque.push(op2 + op1);
                break;
            case "-":
                arrayDeque.push(op2 - op1);
                break;
            case "*":
                arrayDeque.push(op2 * op1);
                break;
            case "/":
                arrayDeque.push(op2 / op1);
                break;
        }
    }
}
