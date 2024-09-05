// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (k >= n)
            return "0";

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            while (!st.isEmpty() && k > 0 && st.peek() > c) {
                st.pop();
                k--;
            }
            st.push(c);
        }

        while (k != 0) {
            st.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();

        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        result.reverse();

        while (result.length() > 1 && result.charAt(0) == '0')
            result.deleteCharAt(0);

        return result.toString();
    }
}