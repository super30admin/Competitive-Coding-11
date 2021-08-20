// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
    public String removeKdigits(String num, int k) {
        if(num == null || num.length() == 0)
            return "0";
        Stack<Character> st = new Stack<>();
        
        for(int i = 0;i < num.length(); i++){
            char c = num.charAt(i);
            while(!st.isEmpty() && k > 0 && st.peek() > c){
                st.pop();
                k--;
            }
            st.push(c);
        }
        
        for(int i = 0;i < k;i++){
            st.pop();
        }
        
        StringBuilder res = new StringBuilder();
        boolean leadingZero = true;

        for(char digit: st) {
            if(leadingZero && digit == '0') 
                continue;
          leadingZero = false;
          res.append(digit);
        }

        if(res.length() == 0)
            return "0";
        return res.toString();
    }
}