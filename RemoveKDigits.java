// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class RemoveKDigits {
    class Solution {
        public String removeKdigits(String num, int k) {
            int len = num.length();
            if(len <= k) return "0";
            LinkedList<Character> st  =  new LinkedList<Character>();
            for(char ch : num.toCharArray()) {
                while(!st.isEmpty() && k >0 && st.peekLast() > ch) {
                    st.removeLast();
                    k-=1;
                }
                st.addLast(ch);
            }

            for(int i=0; i<k; i++) {
                st.removeLast();
            }

            StringBuilder sb = new StringBuilder();
            boolean isLeadingZero = true;
            for(char c : st){
                if(isLeadingZero && c == '0') continue;
                isLeadingZero = false;
                sb.append(c);
            }

            if(sb.length() == 0) return "0";
            return sb.toString();
        }
    }
}
