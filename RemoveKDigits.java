class Solution {
    public String removeKdigits(String nums, int k) {
        
         Stack<Integer> st = new Stack<>();
        
        StringBuilder sb = new StringBuilder();
        
        st.push(Character.getNumericValue(nums.charAt(0)));
        
         for (int i = 1; i < nums.length(); i++) {
             int ch = Character.getNumericValue(nums.charAt(i));
            while(!st.isEmpty() && k > 0 && st.peek() > ch) {
                k--;
                st.pop();
            }
            st.push(ch);
         }
        
        while(k > 0) {
            st.pop();
            k--;
        }
        
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        
        sb.reverse();
        
        return sb.toString();
    }
}