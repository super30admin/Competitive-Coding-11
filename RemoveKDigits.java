// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// maintain stack to keep track of smaller elements, while processing num, if num[i]<stack.peek(), pop(), do while k>0
// pop all nums and form number using string builder, do reverse and remove leading zeros

class Solution {
    public String removeKdigits(String num, int k) {
        
        if(num.length()==0 || k==num.length()){
            return "0";
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for(char d : num.toCharArray()){
            int digit = d-'0'; 
            while(!stack.isEmpty() && k>0 && stack.peek()>digit){
                stack.pop();
                k--;
            }
            
            stack.push(digit);
        }
        
        while(k>0){
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(Integer.toString(stack.pop()));
        }
        
        sb = sb.reverse();
        
        while(sb.length()>1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
}