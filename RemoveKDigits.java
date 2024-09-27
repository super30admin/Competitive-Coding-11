//Time Complexity: O(2n + k) Asymptotic: O(n)
//Space Complexity: O(n)

import java.util.Stack;

public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
        if(num == null || num.length() == 0) return num;
        Stack<Integer> st = new Stack<>();
        st.push(Character.getNumericValue(num.charAt(0)));
        for(int i = 1; i < num.length(); i++){
            int n = Character.getNumericValue(num.charAt(i));
            while(!st.isEmpty() && k >0 && st.peek() > n){
                k--;
                st.pop();
            }
            st.push(n);
        }
        
        for(int i = 0; i < k; i++){
            st.pop();
        }
        
        StringBuilder temp = new StringBuilder();
        for(int i: st){
            temp.append(String.valueOf(i));
        }
        if(temp.length() == 0) return "0";
        String result = temp.toString().replaceFirst("^0*", "");
        if(result.length() == 0) return "0";
        return result;
    }
}
