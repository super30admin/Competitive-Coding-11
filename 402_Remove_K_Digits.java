    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/remove-k-digits/
    Time Complexity for operators : o(n) .. n is the length of the string
    Extra Space Complexity for operators : o(n) .. stack
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) 


    */ 

class Solution {
    public String removeKdigits(String num, int k) {
        
        // base
        if(num == null || num.length() == 0){
            return "";
        }
        
        Stack<Character> stack = new Stack<>();
        
        for(int x = 0;x < num.length(); x++){
            
            char val1 = num.charAt(x);
                        
            while(k > 0 && (!stack.isEmpty() && stack.peek() > val1)){
                stack.pop();
                k--;
            }
            stack.push(val1);
            
        }
        
        // in case if all the characters remcharacters removed and if still k is positive that
        // means we aree pending with some elments
        
        // System.out.println(stack);
        //  System.out.println(k);
        
        for(int x=0;x<k;x++){
            stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
        {
            sb.append(stack.pop());
        }
        
        int index = sb.length()-1;
        while(index>=0 && sb.charAt(index) == '0')
        {
            sb.deleteCharAt(index);
            index--;
        }
        
        if(sb.length() == 0)
        {
            return "0";
        }
        return sb.reverse().toString();
    }
}