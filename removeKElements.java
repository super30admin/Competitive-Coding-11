// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : was not able to comeup with solution myself and it took
//a long time for me to understand it and solve it
class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k)
            return "0";
        Stack<Character> st = new Stack<>();
        Stack<Character> stChar = new Stack<>();

        for (char c : num.toCharArray()) {
            // remove all characters greater than current charachters
            while (k > 0 && !st.isEmpty() && c < st.peek()) {
                k--;
                st.pop();
            }
            st.push(c);
        }
        // if any greater numbers are remaining, remove them too
        while (k > 0) {
            st.pop();
            k--;
        }
        boolean leadingzero = true;
        // now we are adding all numbers in other stack to read result in correct order
        while (!st.isEmpty()) {
            stChar.push(st.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!stChar.isEmpty()) {
            if (leadingzero && stChar.peek() == '0') {
                stChar.pop();
                continue;
            }
            leadingzero = false;
            sb.append(stChar.pop());
        }
        String result = sb.toString();
        if (result == "") {
            return "0";
        }
        return result;
    }
}