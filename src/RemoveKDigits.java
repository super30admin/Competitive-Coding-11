// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/**
 * https://leetcode.com/problems/remove-k-digits/
 * Push every digit see so far on the stack,
 * remove all the digits (at max k) from the stack which are larger than current digit
 * form a number from stack in reverse order (stack top digit goes to the end of the number/right side)
 * remove precedeeing zeros from the final number
 *
 */

class Solution {
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