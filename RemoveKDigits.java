// https://leetcode.com/problems/remove-k-digits/

// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            if(!st.isEmpty()) {
                while(!st.isEmpty() && ch < st.peek() && k > 0) {
                    st.pop();
                    k--;
                }
            }
            st.push(ch);
        }

        while(k > 0) {
            st.pop();
            k--;
        }

        // build the final string, while removing the leading zeros.
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;

        for(char digit: st) {
            if(leadingZero && digit == '0') continue;
            leadingZero = false;
            ret.append(digit);
        }
        /* return the final string  */
        if (ret.length() == 0) return "0";
        return ret.toString();
    }
}