// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public String removeKdigits(String num, int k) {
        
        if(num.length() == k) {
            return "0";
        }
        
            
        Stack<Character> stack = new Stack<>();
        
        for(char c: num.toCharArray()){
            while(k > 0 && !stack.isEmpty() && stack.peek() > c){
                stack.pop();
                k--;
            }
            stack.push(c);
            
        }
        
        while(k > 0){
            stack.pop();
            k--;            
        }
        
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        while(result.length() > 1 && result.charAt(result.length() - 1) == '0') {
            result.deleteCharAt(result.length() - 1);
        }
        return result.reverse().toString();
    }
}