// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// first take a stack, add if the value is grater then last else pop till the value at top is grater then current. then pop the remaining k values.  then check for the leading 0 and remove it.
// Your code here along with comments explaining your approach
class Solution {
    public String removeKdigits(String num, int k) {
       Stack<Integer> st = new Stack<>();
       if(num.length() == k) return "0";
       for(int i = 0; i < num.length(); i++){
           int n = num.charAt(i) - '0';
           while(!st.isEmpty() && k > 0 && n < st.peek()){
                st.pop();
                k--;
           }
           st.add(n);
       }
       for(int i = 0; i<k; i++) {
        st.pop();
       }
       // build the final string, while removing the leading zeros.
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        for(int digit: st) {
            if(leadingZero && digit == 0) continue;
            leadingZero = false;
            ret.append(digit);
        }

        /* return the final string  */
        if (ret.length() == 0) return "0";
        return ret.toString();
    }
}
