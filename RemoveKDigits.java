import java.util.Stack;

// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :getting started

// Your code here along with comments explaining your approach
public class RemoveKDigits {


    class Solution {
        public String removeKdigits(String num, int k) {
            int strSize = num.length();
            if(k == 0) return num;//if value of k is zero return original string
            if(k == strSize) return "0";//return 0 string as all numbers are to be removed

            Stack<Character> st = new Stack<>();

            for (int i = 0; i < strSize; i++) {
                char c = num.charAt(i);

                //if stack is not empty and k is greater than = and previous digit is greater than current
                //pop stack and decrement k
                while(!st.isEmpty() && k > 0 && st.peek() > c){
                    st.pop();
                    k--;
                }
                st.push(c);
            }

            //remove values from tail as values now are in ascending order and all maximas are in the tail
            for (int i = 0; i < k; i++) {
                st.pop();
            }

            //recreate string from stack
            StringBuilder sb = new StringBuilder();
            while(!st.isEmpty()){
                sb.append(st.pop());
            }

            //flip sb object as stack is LIFO
            sb.reverse();

            //remove leading zero
            while(sb.length() > 1 && sb.charAt(0) == '0'){
                sb.deleteCharAt(0);
            }

            return sb.toString();

        }
    }


}
