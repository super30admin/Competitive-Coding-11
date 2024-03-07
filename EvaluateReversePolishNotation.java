// https://leetcode.com/problems/evaluate-reverse-polish-notation/

// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack1 = new Stack();
        int exp = 0;
        if(tokens.length == 1) {
            return Integer.valueOf(tokens[0]);
        }
        // if(tokens.len)
        for(int i=0; i < tokens.length; i++) {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int b = Integer.valueOf(stack1.pop());
                if(!stack1.isEmpty()){
                    exp = Integer.valueOf(stack1.pop());
                }
                exp = resolveExp(exp, b, tokens[i]);
                stack1.push(exp);
            } else {
                stack1.push(Integer.parseInt(tokens[i]));
            }
            // System.out.println(stack1);
        }
        return exp;
    }

    public static int resolveExp(int a, int b, String token) {
        if(token.equals("+")) {
            return  a + b;
        } else if(token.equals("-")) {
            return a - b;
        } else if(token.equals("*")) {
            return a * b ;
        } else if(token.equals("/")) {
            return a/b;
        }
        return 0;
    }
}