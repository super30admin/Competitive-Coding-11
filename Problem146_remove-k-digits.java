// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == 1 && k == 1)
            return "0";
        Stack<Character> stack = new Stack<Character>();
        stack.push(num.charAt(0));
        for(int i = 1; i < num.length(); i++) {
            while(!stack.isEmpty() && stack.peek() > num.charAt(i) && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        
        while(k > 0){
            stack.pop();
            k--;            
        }
        
        if(stack.isEmpty())
            return "0";
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        while(sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
       
        return sb.toString();
    }
}