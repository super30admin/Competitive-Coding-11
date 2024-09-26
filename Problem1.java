// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        
        for(String token: tokens) {
            if(set.contains(token)) {
                int operand_1 = stack.pop();
                int operand_2 = stack.pop();
                if(token.equals("+")) {
                    stack.push(operand_2 + operand_1);
                }
                else if(token.equals("-")) {
                    stack.push(operand_2 - operand_1);
                }
                else if(token.equals("*")) {
                    stack.push(operand_2 * operand_1);
                }
                else if(token.equals("/")) {
                    stack.push(operand_2 / operand_1);
                }
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
}