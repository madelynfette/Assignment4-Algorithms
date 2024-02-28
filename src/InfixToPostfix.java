import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        String infix ="a+b*(c^d-e)^(f+g*h)-i";
        String postfix = infixToPostfix(infix);

        System.out.println("Infix: "   + infix);
        System.out.println("Postfix: " + postfix);
    }
    public static String infixToPostfix(String infix) {
        //stack for operators
        Stack<Character> opStack = new Stack<>();
        //string for postfix
        String postfix ="";
        char[] arr=infix.toCharArray();

        //iterate through infix
        for (int i =0; i< arr.length; i++) {
            char c = arr[i];

            //check char for digits or letters
            if ((c >= 'a' && c <= 'z') || (c>= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                //concat to postfix
                postfix += c;
                //if parenthesis, push to stack
            } else if (c =='(') {
                opStack.push(c);
            } else if (c== ')') {
                //pop and add to postfix until first parenthesis
                while (!opStack.isEmpty() && opStack.peek() != '(') {
                    postfix += opStack.pop();
                }
                opStack.pop();

                //if operator, pop and add to postfix when precedence is > or = to current
            } else {
                while (!opStack.isEmpty() && precedence(opStack.peek()) >= precedence(c)) {
                    postfix += opStack.pop();
                }
                //push current
                opStack.push(c);
            }
        }





        //pop remaining and add to postfix
        while (!opStack.isEmpty()) {
            postfix += opStack.pop();
        }

        return postfix;
    }


    private static int precedence(char operator) {
        if (operator == '^') {
            return 3;

        } else if (operator =='*' || operator == '/' ) {
            return 2;

        } else if (operator =='+' || operator == '-') {
            return 1;

        } else {
            return 0;
        }



    }

}
