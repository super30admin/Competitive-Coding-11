//TC: O(n)
//SC: O(n)
//approach: stack to put in integers, pop and operate on operation and push result back to stack

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String token = tokens[i];
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                Integer a = s.pop();
                Integer b = s.pop();
                System.out.println("a:"+a+" b:"+b);
                if(token.equals("+")) s.push( b+a);
                else if(token.equals("-")) s.push(b-a);
                else if ( token.equals("*")) s.push(b*a);
                else  s.push(b/a);


            }else{
                Integer num = Integer.parseInt(token);
                s.push(num);
            }
        }
        return s.pop();
    }
}
