// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class ReversePolishNotation {
    class Solution {
        public int evalRPN(String[] tokens) {
            int n = tokens.length;
            if(n == 0 || tokens == null)
                return 0;

            Stack<Integer> stack = new Stack<>();
            for(String token : tokens){
                if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                    if(!stack.isEmpty()){
                        int n1 = stack.pop();
                        int n2 = stack.pop();
                        int re = eval(n2, n1, token);
                        stack.push(re);
                    }
                }
                else{
                    stack.push(Integer.parseInt(token));
                }
            }
            return stack.pop();
        }
        private int eval(int first, int second, String op){
            System.out.println(op);
            if(op.equals("+")){
                return first + second;
            }
            else if(op.equals("-")){
                return first - second;
            }
            else if(op.equals("*")){
                return first * second;
            }
            else{
                return first / second;
            }
        }
    }
}
