// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for(String token : tokens) {
            if(token.equals("+")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first + second);
            } else if(token.equals("-")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first - second);
            } else if(token.equals("*")) {
                int second = stack.pop();
                int first = stack.pop();
                
                stack.push(first * second);
            }else if(token.equals("/")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first / second);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public String removeKdigits(String num, int k) {
        if(num == null || num.length() == 0 || num.length() == k) {
            return "0";
        }
        if(k == 0) {
            return num;
        }
        Stack<Character> stack = new Stack<>();
        Stack<Character> resultStack = new Stack<>();
        //num = 1432219
        //k = 3
        
        for(int i = 0 ; i < num.length(); i++) {
            char c = num.charAt(i);
            while(!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop(); 
                k--;
            }
            stack.push(c);
        }
        while(k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            char c = stack.pop();
            resultStack.push(c);
        }
        
        while(!resultStack.isEmpty() && resultStack.peek() == '0') {
            resultStack.pop();
        }
        while(!resultStack.isEmpty()) {
            sb.append(resultStack.pop());
        }
        if(sb.length() == 0) {
            return "0";
        }
        return sb.toString();
       
    }
}