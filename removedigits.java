// TC: O(n)
// SC: O(n)
class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length()) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < num.length() ; i++) {
            char curr = num.charAt(i);

            while(k>0 && !st.isEmpty() && st.peek() > curr) {
                st.pop();
                k--;
            }
            st.add(curr);
        }
        while( k!= 0) {
            st.pop();
            k--;
        }
        while(!st.isEmpty()) {
            result.insert( 0, st.pop() );
        }
        int numOfZeros = 0;
        for(int i=0 ; i<result.length() ; i++) {
            if(result.charAt(i) == '0') {
                numOfZeros++;
            } else {
                break;
            }
        }
        if(numOfZeros == result.length()) {
            return "0";
        }
        return result.substring(numOfZeros, result.length()).toString();
    }
}