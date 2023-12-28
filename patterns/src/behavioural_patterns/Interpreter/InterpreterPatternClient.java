package behavioural_patterns.Interpreter;


import java.util.Stack;

// Step 1: Define Pattern interface
interface Pattern {
    public String conversion(String exp);
}

// Step 2: Implement InfixToPostfixPattern class that implements the Pattern interface
class InfixToPostfixPattern implements Pattern {

    @Override
    public String conversion(String exp) {
        int priority = 0; // for the priority of operators.
        String postfix = "";
        Stack<Character> s1 = new Stack<Character>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%') {
                // check the precedence
                if (s1.isEmpty()) {
                    s1.push(ch);
                } else {
                    Character chTop = s1.peek();
                    if (chTop == '*' || chTop == '/' || chTop == '%') {
                        priority = 1;
                    } else {
                        priority = 0;
                    }

                    if (priority == 1) {
                        if (ch == '*' || ch == '/' || ch == '%') {
                            postfix += s1.pop();
                            i--;
                        } else {
                            postfix += s1.pop();
                            i--;
                        }
                    } else {
                        if (ch == '+' || ch == '-') {
                            postfix += s1.pop();
                            s1.push(ch);
                        } else {
                            s1.push(ch);
                        }
                    }
                }
            } else {
                postfix += ch;
            }
        }

        // Pop remaining operators from the stack and append to the postfix string
        while (!s1.isEmpty()) {
            postfix += s1.pop();
        }
        return postfix;
    }
}

// Step 3: Create InterpreterPatternClient class to test the conversion
public class InterpreterPatternClient {
    public static void main(String[] args) {
        String infix = "a+b*c";

        InfixToPostfixPattern ip = new InfixToPostfixPattern();

        String postfix = ip.conversion(infix);
        System.out.println("Infix:   " + infix);
        System.out.println("Postfix: " + postfix);
    }
}
