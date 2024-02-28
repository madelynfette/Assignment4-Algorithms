import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {
        String s1 ="{[()]}";
        String s2 = "{[(])}" ;
        String s3 ="{{[[(())]]}}";

        System.out.println("String 1: " +s1);
        System.out.println("Balanced? " +isBalanced(s1));

        System.out.println("String 2: " +s2);
        System.out.println("Balanced? " +isBalanced(s2));

        System.out.println("String 3: "+ s3);
        System.out.println("Balanced? " + isBalanced(s3));
    }

    public static String isBalanced(String s) {
        //store brackets
        Stack<Character> stack = new Stack<>() ;

        //go through each character in string
        for (int i = 0; i< s.length(); i++) {
            //check index i
            char c = s.charAt(i);
            //if char is opening bracket, push to stack
            if (c == '('|| c == '[' || c == '{') {
                stack.push(c);
            } else {
                //if empty, no matching bracket, return no
                if(stack.isEmpty()) {
                    return "NO";
                }
                //check current match opening bracket
                char top = stack.pop();
                if ((c == ')' && top!= '(') ||(c == ']' && top !='[') || (c =='}' && top!= '{')) {
                    return "NO";
                }
            }
        }
        if(stack.isEmpty()){
            return "YES";

        }else{
            return "NO";






        }
    }






}

