// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class RemoveKdigits {
    class Solution {
        public String removeKdigits(String num, int k) {
            Stack<Character> stack = new Stack();

            for(char digit : num.toCharArray()) {
                while(!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                    stack.pop();
                    k--;
                }
                stack.push(digit);
            }

            //remove if k > 0
            for(int i = 0; i < k; i++) {
                stack.pop();
            }

            // build the final string, while removing the leading zeros.
            StringBuilder sb = new StringBuilder();
            boolean leadingZero = true;
            for(char digit: stack) {
                if(leadingZero && digit == '0')
                    continue;

                leadingZero = false;
                sb.append(digit);
            }

            if (sb.length() == 0)
                return "0";
            return sb.toString();
        }
    }
}
