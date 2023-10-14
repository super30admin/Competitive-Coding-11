
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : The problem can be solved using stack, the main idea is to most recently calculated value, Stack property is first in first out and can be used to solve the problem


// Your code here along with comments explaining your approach



class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack =  new Stack<>();
        Set<String> opertorSet = new HashSet<>();
        
        opertorSet.add("+");
        opertorSet.add("-");
        opertorSet.add("/");
        opertorSet.add("*");
        
        for(String s: tokens){
            if(opertorSet.contains(s)){
                int first = stack.pop();
                int second = stack.pop();
                
                if(s.equals("+")){
                    stack.push(second+first);
                }else if(s.equals("-")){
                    stack.push(second-first);
                }else if(s.equals("*")){
                    stack.push(second*first);
                }else if(s.equals("/")){
                    stack.push(second/first);
                }
            }else
                stack.push(Integer.parseInt(s));
        }
        return stack.pop();
    }
}