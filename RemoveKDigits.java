package CompetitiveCoding_Dec27;

import java.util.Stack;

class RemoveKDigits {
	
    public String removeKdigits(String num, int k) {
         
      // edge
        if (num == null || num.length() == 0) {
            return "";
        } else if (num.length() == k) {
            return "0";
        }
        // logic
        Stack<Character> st = new Stack<>();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            while(!st.isEmpty() && k > 0 &&st.peek() > ch){
                st.pop();
                k--;
            }
            st.push(ch);
         }
        while(k > 0){
            st.pop();
            k--;
        }
        // popout from stack and form output string
        while (!st.isEmpty()) {
            result.append(st.pop());
        }
        result.reverse();
        int i = 0;
        while (i < result.length() && result.charAt(i) == '0') {
            i++;
        }
        String finalRes = result.substring(i);
        if (finalRes.length() == 0) {
            return "0";
        } else {
            return finalRes;
        }

       
    }
}   