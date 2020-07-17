
class RemoveK {
    // Time Complexity : O(N) where N is length of num array
    // Space Complexity : O(N) size of the stack
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this :No


    /**
     * Approach:
     * 1. Add digits to stack. If the next digit is less than top element of stack, pop the element.
     * 2. At the end reverse the elements of stack and return the output
     */

    public String removeKdigits(String num, int k) {
        
        if(num == null || num.length() == 0 || k < 1){
            return num;
        }
        
        if(num.length() <= k){
            return "0";
        }
        
        Stack<Integer> stack = new Stack();
        int count = 0;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        
        while(i < num.length()){
            
            while(count < k && !stack.isEmpty() && num.charAt(i) < num.charAt(stack.peek())){
                stack.pop();
                count++;
            }
            stack.push(i);
            i++;
            
        }
        
        while(count < k){
            stack.pop();
            count++;
        }
        
        while(!stack.isEmpty()) {
            sb.insert(0, num.charAt(stack.pop()));
        }
        
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
        
    }
}