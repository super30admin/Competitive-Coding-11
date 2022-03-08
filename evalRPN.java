import java.util.Stack;

// Time Complexity : Add : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        evalRPN(tokens);
    }

    public static int evalRPN(String[] tokens) {
        //bse
        if(tokens == null || tokens.length == 0)
            return -1;

        Stack<Integer> st = new Stack<>();

        for(String token : tokens) {
            int a = 0;
            int b = 0;
            int c = 0;

            if(token.equals("+") || token.equals("-")  || token.equals("/")  || token.equals("*") ){
                a = st.pop();
                b = st.pop();
                if(token.equals("+") ){

                    c = a + b;
                    // st.push(c);
                }
                else if (token.equals("-")) {
                    // b = st.pop();
                    // a = st.pop();
                    c = b - a;
                    // st.push(c);
                }
                else if (token.equals("/")) {
                    // b = st.pop();
                    // a = st.pop();
                    c = b / a;
                    // st.push(c);
                }
                else {
                    // b = st.pop();
                    // a = st.pop();
                    c = b * a;
                    // st.push(c);
                }
                st.push(c);
            } else {
                st.push(Integer.parseInt(token));
            }
        }

        // int result = Integer.parseInt(st.pop());
        return st.pop();
    }
}

