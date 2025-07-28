/*
Time Complexity - O(N) for iteration of string and iteration of stack O(K)
Space Complexity - O(N)
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
*/
import java.util.Stack;

public class RemoveKDigits_LC_402 {
    public String removeKdigits(String num, int k) {
        if(num.length() == k) return "0";
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<num.length(); i++) { // 10200
            char c = num.charAt(i);
            while(k >0 && !st.isEmpty() && c < st.peek()) {
                // if(!st.isEmpty() && c < st.peek()){
                st.pop();
                k--;
            }
            st.push(num.charAt(i)); //12345
        }
        if(k>0){
            while(k > 0){
                st.pop();
                k--;
            }
        }

        while(!st.isEmpty()) {
            sb.append(st.pop());
        }

        sb.reverse();
        int idx = 0;
        while (idx < sb.length() && sb.charAt(idx) == '0') {
            idx++;
        }

        return idx == sb.length() ? "0" : sb.substring(idx);
    }
}