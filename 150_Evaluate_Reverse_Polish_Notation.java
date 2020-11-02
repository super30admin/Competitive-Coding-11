    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/evaluate-reverse-polish-notation/
    Time Complexity for operators : o(n) .. n is the length of the string
    Extra Space Complexity for operators : o(n) .. stack
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) Add (+, -, *, /) characters to the HashSet.
                    B) Start with the starting from the given token array.
                    C) Pop the first two elememnts from the stack if we get one of the above characters.
                    D) then do the operatos and return it on to the stacl.
                    E) If it is integer then push on to the stack.
                    F) At thee end, return the top element is the answer.
    */ 

class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0)
            return 0;
        
        HashSet<String> hs = new HashSet<>();
        hs.add("+"); hs.add("-"); hs.add("*"); hs.add("/");
        Stack<Integer> stack = new Stack<>();
        for(String str : tokens){ // time complexity will be O(n) and space also O(n)
            if(hs.contains(str) && stack.size() > 1 ){
                int top2 = stack.pop();
                int top1 = stack.pop();
                if(str.equals("+")){
                    stack.push(top1+top2);
                }else if(str.equals("-")){
                    stack.push(top1-top2);
                }else if(str.equals("*")){
                    stack.push(top1*top2);
                }else{
                    stack.push(top1/top2);
                }
            }else{
                stack.push(Integer.parseInt(str));
            }
        }
        
        return stack.peek();
    }
}