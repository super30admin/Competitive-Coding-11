// Problem 150. Evaluate Reverse Polish Notation
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        for (String s : tokens) {
            if (set.contains(s)) {
                int second = stack.pop();
                int first = stack.pop();
                if (s.equals("+")) {
                    stack.push(first + second);
                } else if (s.equals("-")) {
                    stack.push(first - second);
                } else if (s.equals("*")) {
                    stack.push(first * second);
                } else if (s.equals("/")) {
                    stack.push(first / second);
                }
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
