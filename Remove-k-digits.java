/*Time Complexity: O(N)

Space Complexity: O(N)

Did this code successfully run on Leetcode : Yes

Approach: Using Stack, push the string val in the stack, if the peek element is greater than
curr element the pop from stack and reduce k value. Finally, reverse the stack and return.

Prob: 402. Remove K Digits
*/

import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length()) return "0";
        Stack<Character> st = new Stack<>();
        int i = 0;
        while(i < num.length()){
            while(k > 0 && !st.isEmpty() && st.peek() > num.charAt(i)){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
            i++;
        }
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        while(sb.toString().startsWith("0")){
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}