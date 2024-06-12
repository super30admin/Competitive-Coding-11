// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens==null||tokens.length==0){
            return 0;
        }
        Set<String> set=new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        
        set.add("+"); set.add("-");set.add("*");set.add("/");
        
        for(String s:tokens){
            if(set.contains(s)){
               int a=stack.pop();
               int b=stack.pop();
                if(s.equals("+")){
                    stack.push(a+b);
                }
                 else if(s.equals("-")){
                    stack.push(b-a);
                }
                 if(s.equals("*")){
                    stack.push(a*b);
                }
                 if(s.equals("/")){
                    stack.push(b/a);
                }
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}