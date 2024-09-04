// Time Complexity : O(n)  - where n is length of string[]
// Space Complexity : O(n) -  where n is length of string[]
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str : tokens) {
            if(str.equals("+")){
                stack.push(stack.pop() + stack.pop());
            } else if(str.equals("-")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first - second);
            } else if(str.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if(str.equals("/")){
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first / second);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.peek();
    }
}