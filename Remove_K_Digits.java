import java.util.Stack;
//Time Complexity : O(n)
//Space Complexity : O(n)
class Solution {
    public String removeKdigits(String nums, int k) {
          if (k == nums.length()) return "0";
        Stack<Integer> st = new Stack<>();
        //push first no in stack
        st.push(Character.getNumericValue(nums.charAt(0)));
        //run stack from first to last element
        for (int i = 1; i < nums.length(); i++) {
        //if peek element is greater than incoming element 
        //pop the peek element and decrease k
            
            while (!st.isEmpty() && st.peek() > Character.getNumericValue(nums.charAt(i)) && k > 0) {
                st.pop();
                k--;
            }
            //push element
            st.push(Character.getNumericValue(nums.charAt(i)));
        }
        StringBuilder sb = new StringBuilder();
        
        //pop extra elements
        while (k > 0) {
            st.pop();
            k--;
        }
        //append stack elements
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        //reverse and convert to string and return 
        sb.reverse();
        //if 0 is at the beginning delete 0
        while (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.toString();
    }
}