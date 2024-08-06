// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nos


class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        HashSet<String> set = new HashSet<>();

        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");

        for(String s : tokens){
            if(set.contains(s)){
                int first = stack.pop();
                int second = stack.pop();
                if(s.equals("+")){
                    stack.push(first + second);
                }
                else if(s.equals("-")){
                    stack.push(second - first);
                }
                else if(s.equals("*")){
                    stack.push(first * second);
                }
                else if(s.equals("/")){
                    stack.push(second/first);
                }
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}