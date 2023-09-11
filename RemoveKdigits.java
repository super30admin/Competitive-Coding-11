package CompetitiveCoding11;
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
import java.util.Stack;

public class RemoveKdigits {

    public String removeKdigits(String num, int k) {
        StringBuilder result = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(int i=0; i<num.length(); i++){
            char c = num.charAt(i);
            while(!st.isEmpty() && c < st.peek() && k>0){
                st.pop();
                k--;
            }
            st.push(c);
        }

        while(k>0){
            st.pop();
            k--;
        }

        boolean leadingZero = true;
        for(char c: st){
            if(leadingZero && c == '0') continue;
            leadingZero = false;
            result.append(c);
        }

        if(result.length() == 0) result.append("0");
        return result.toString();
    }
}

