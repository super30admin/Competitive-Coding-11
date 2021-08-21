// Time Complexity : O(N) 
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int evalRPN(String[] tokens) {
        int totalSum = 0;
        if(tokens.length == 1 && isInteger(tokens[0])) totalSum = Integer.parseInt(tokens[0]);
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<tokens.length;i++) {
            if(isInteger(tokens[i]))
                s.push(Integer.parseInt(tokens[i]));
            else {
                int secondOperand = s.pop();
                int firstOperand = s.pop();
                if(tokens[i].equals("+")) totalSum = firstOperand + secondOperand;
                if(tokens[i].equals("-")) totalSum = firstOperand - secondOperand;
                if(tokens[i].equals("*")) totalSum = firstOperand * secondOperand;
                if(tokens[i].equals("/")) totalSum = firstOperand / secondOperand;
                s.push(totalSum);
            }
        }
        return totalSum;
    }
    
    public boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
        }
         catch (NumberFormatException e) {
            return false;
         }
        return true;
    }
}
