// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public String removeKdigits(String num, int k) {
        if(k >= num.length()) return "0";
        int m = num.length();
        int i = 0 ;
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(Character digit:num.toCharArray())
        {
            while(!stack.isEmpty() && k>0 && stack.peek()>digit)
            {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        while(k>0) 
        {
            stack.pop();
            k--;
        }
        while(!stack.isEmpty()) sb.append(stack.pop());
        sb.reverse();

        
//      //post processing- removing leading zeros
        int x = 0;
        while(x<sb.length())
        {
            if(sb.charAt(x)!='0')
            {
                break;
            }
            x++;
        }
        sb.delete(0,x);
        return sb.length()>0 ?sb.toString():"0";
        
    }
}