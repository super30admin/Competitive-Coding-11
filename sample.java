// Problem 1 - Evaluate Reverse Polish Notation
// Time Complexity : O(n) where n = length of array
// Space Complexity : O(n) extra space for stack

// Your code here along with comments explaining your approach
class Solution {
    public int evalRPN(String[] tokens) {
        // base condition
        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        Stack<String> stack = new Stack<>();
        // loop over string array
        for (int i=0; i<tokens.length; i++) {
            // string at ith index
            String s = tokens[i];
            // if string is an operator
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                // pop 1st two elements from stack
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                // perform operation
                if (s.equals("+")) {
                    res = num1 + num2;
                } else if (s.equals("-")) {
                    res = num1 - num2;
                } else if (s.equals("*")) {
                    res = num1 * num2;
                } else {
                    res = num1 / num2;
                }
                // push the result to stack as string
                stack.push(Integer.toString(res));
            } else { // if element is not an operator
                // push the number to stack
                stack.push(s); 
            }
        }
        // return the popped element from stack as integer          
        return Integer.parseInt(stack.pop());
    }
}

// Problem 2 - Remove K Digits
// Time Complexity : O(n) where n = length of array
// Space Complexity : O(n) extra space for stack

// Your code here along with comments explaining your approach
class Solution {
    public String removeKdigits(String num, int k) {
        // base condition
        if (k == 0) {
            return num;
        }
        if (k >= num.length()) {
            return "0";
        }
        
        Stack<Character> stack = new Stack<>();
        // loop over array
        for (int i=0; i<num.length(); i++) {
            // get char at ith index
            char c = num.charAt(i);
            // while condition to check if stack is not empty and peek is greater than curr and k is grater than 0
            while (!stack.isEmpty() && stack.peek() > c && k > 0) {
                // pop the top most element
                stack.pop();
                // decrement k by 1
                k--;
            }
            // push the current element to stack
            stack.push(c);
        }
        
        // 11111
        while (k > 0) {
            stack.pop();
            k -= 1;
        }
        
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        // 0 2 0 0 2 // prepare a string
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        sb.reverse();
        // remove 0's from the start if any
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        // return the string
        return sb.toString();
    }
}
