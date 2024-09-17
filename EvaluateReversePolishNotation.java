import java.util.Stack;

// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :understanding what reverse polish notation is

// Your code here along with comments explaining your approach
public class EvaluateReversePolishNotation {
    class Solution {
        public int evalRPN(String[] tokens) {
            //create stack for integer values
            Stack<Integer> st = new Stack<>();

            //iterate over tokens
            for(String token:tokens){

                //check if token is not an operator then perform operation on operands
                if(token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-")){

                    int res = 0;
                    int num2 = st.pop();
                    int num1 = st.pop();

                    switch(token){
                        case "*":
                            res = num1 * num2;
                            break;
                        case "/":
                            res = num1 / num2;
                            break;
                        case "+":
                            res = num1 + num2;
                            break;
                        case "-":
                            res = num1 - num2;
                            break;
                    }
                    st.push(res);//push result to stack
                }else{
                    st.push(Integer.valueOf(token));//push operand on to stack
                }
            }
            return st.pop();//pop top of stack as final result
        }
    }
}
