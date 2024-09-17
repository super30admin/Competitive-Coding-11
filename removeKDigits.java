// Time: O(k*n) 
// Space: O(n)
// Idea here is to greedily chose first maximal point where the peek is attained
// as it corresponds to digit*10*n-i location
// this minimizes the value of whole expression.
// To achieve it stack is used where peek is checked and if it is greater than incoming character
// stack is popped untill maximals are eliminated of k is reached to 0. We continue it till the end of string.
// edge cases dictates if there was not maximal character and k remains greater than 0 till end of traversal.
// in that case we keep popping from last element untill it reaches 0;
// if there are 0s in prefix, we just elimiante them to form proper value.
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        int n = num.length();
        if(k==n) return "0";
        int i = 0;
        while(i<n){
            while( k>0 && !st.isEmpty() && st.peek()>num.charAt(i)) {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
            i++;
        }
        
        while(k>0){
            st.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) sb.append(st.pop());
        sb.reverse();
        
        while(sb.length()>1 && sb.charAt(0)=='0') sb.deleteCharAt(0);
        
        return sb.toString();
    }
}