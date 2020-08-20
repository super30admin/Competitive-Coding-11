// Time Complexity : O(n) --> where n is the length of the input string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode (402): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public String removeKdigits(String num, int k) {
    Stack<Character> st = new Stack<>();
        
    for (char c : num.toCharArray()) {
      while (st.size() > 0 && k > 0 && st.peek() > c) {
        st.pop();
        k -= 1;
      }
      st.push(c);
    }
        
    /* remove the remaining digits from the tail. */
    for (int i = 0; i < k; i++) st.pop();
        
    // build the final string, while removing the leading zeros.
    StringBuilder sb = new StringBuilder();
    boolean isLeadingZero = true;
    for(char c: st) {
      if(isLeadingZero && c == '0') continue;
      isLeadingZero = false;
      sb.append(c);
    }
        
    /* return the final string  */
    if (sb.length() == 0) return "0";
    return sb.toString();
    }
}