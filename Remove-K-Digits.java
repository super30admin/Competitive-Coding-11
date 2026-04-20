// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
The idea is to check if the leftmost visited integer is greater than the current one or not.If so, we want to
drop that greater digit and add the current one to the stack.We repeat this until k times.If its a monotonically
increasing sequence, then we simply push all the digits to the stack and remove the lastly added ones until
k times.We also need to check if there are any trailing zeroes for the final result, so we iterate through the
stack and check for the 1st time if string builder is empty and incoming digit is not zero, then only we want
to append it to the string builder.Finally, we check if we are able to form a number, if not, we return 0.
 */
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();
        int count = 0;
        int i = 0;

        while(i < num.length()) {
            int digit = num.charAt(i) - '0';
            while(!st.isEmpty() && st.peek() > digit && count < k) {
                st.pop();
                count++;
            }
            st.push(digit);
            i++;
        }

        while(count < k) {
            st.pop();
            count++;
        }

        StringBuilder sb = new StringBuilder();

        for(int digit : st) {
            if(!(sb.length() == 0 && digit == 0)) {
                sb.append(digit);
            }
        }

        return sb.length() == 0 ? "0" :  sb.toString();
    }
}