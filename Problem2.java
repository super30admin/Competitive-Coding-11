import java.util.Stack;

// Time Complexity :O(n) where n is the length of the num arrays
// Space Complexity :O(n) where n is the length of the num arrays
// Did this code successfully run on Leetcode :yes
public class Problem2 {
    public String removeKdigits(String num, int k) {

        Stack<Character> st = new Stack<Character>();
        StringBuilder result = new StringBuilder();
        st.push(num.charAt(0));

        for(int i = 1; i<num.length(); i++){
            Character c = num.charAt(i);
            int currentDigit = c-'0';

            while(!st.isEmpty() && currentDigit < st.peek()-'0' && k>0){
                st.pop();
                k--;
            }
            st.push(c);
        }
        //pop more if needed
        while(k>0){
            st.pop();
            k--;
        }

        while(!st.isEmpty()){
            result.insert(0, st.pop());
        }
        //remove leading 0s
        int i = 0;
        while(i < result.length() && result.charAt(i) == '0'){
            i++;
        }
        result.delete(0, i);

        if(result.isEmpty()) return "0";
        return result.toString();
    }

}
