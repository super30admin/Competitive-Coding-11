// Time Complexity : O(n)
// Space Complexity : O(n) for worst case
// Did it run of Leetcode: yes
import java.util.Stack;

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();

        if(k >= num.length()) return "0";

        for(int i = 0 ; i < num.length(); i++){
            int digit = num.charAt(i) - '0';
            while(!st.isEmpty() && digit < st.peek() && k > 0){
                st.pop();
                k--;
            }
            st.push(digit);
        }

        while(k > 0){
            st.pop();
            k--;
        }

        //form result number
        StringBuilder sb = new StringBuilder();
        Boolean flag = true; // to check for leading zeros
        for(int digit: st){
            if(flag && digit == 0) continue;
            flag = false;
            sb.append(digit);
        }

        if (sb.length() == 0) return "0";
        return sb.toString();
    }
}
