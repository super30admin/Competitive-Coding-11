// Time Complexity :O(n) where n is the length of the tokens arrays
// Space Complexity :O(n) where n is the length of the tokens arrays
// Did this code successfully run on Leetcode :yes
import java.util.HashSet;
import java.util.Stack;

public class Problem1 {
    public int evalRPN(String[] tokens) {
        if(tokens.length < 2){
            return Integer.parseInt(tokens[0]);
        }

        int len = tokens.length;
        Stack<Integer> st = new Stack<>();
        HashSet<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");

        for(int i =0; i<len; i++){
            String currentStr = tokens[i];
            if(set.contains(currentStr)){
                int rightOperand = st.pop();
                int leftOperand = st.pop();
                //evaluate
                int expr = 0;
                if(currentStr.equals("+")){
                    expr = leftOperand + rightOperand;
                }else if(currentStr.equals("-")){
                    expr = leftOperand - rightOperand;
                }else if(currentStr.equals("*")){
                    expr = leftOperand * rightOperand;
                }else{
                    expr = leftOperand / rightOperand;
                }
                st.push(expr);
            }else{
                st.push(Integer.parseInt(currentStr));
            }
        }
        return st.pop();
    }
}
