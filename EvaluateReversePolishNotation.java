// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class EvaluateReversePolishNotation {
    class Solution {
        public int evalRPN(String[] tokens) {
            String operators = "+-*/";
            int len = tokens.length;
            if(tokens == null || len < 1) return 0;

            Stack<Integer> st = new Stack<>();
            for(int i=0; i< len; i++) {
                String currEle = tokens[i];
                if(!operators.contains(currEle)) {
                    st.push(Integer.valueOf(currEle));
                    continue;
                }

                int num2 = st.pop();
                int num1 = st.pop();
                int currResult = 0;

                if(currEle.equals("+")) {
                    currResult = num1 + num2;
                } else if(currEle.equals("-")) {
                    currResult = num1 - num2;
                }else if(currEle.equals("*")) {
                    currResult = num1 * num2;
                }else {
                    currResult = num1 / num2;
                }
                st.push(currResult);
            }
            return st.pop();
        }
    }
}
