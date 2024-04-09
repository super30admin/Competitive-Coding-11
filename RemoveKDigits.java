/**
TC, SC - O(N)
*/
class Solution {
    public String removeKdigits(String num, int k) {
        if(k >= num.length()) return "0";
        Stack<Character> st = new Stack<>();
        int n = num.length();
        int i=0;
        while(i<n){

            while(!st.isEmpty() && k>0 && st.peek() > num.charAt(i)){
                st.pop();
                k--;
            }
            if(!st.isEmpty() || num.charAt(i) != '0' ){
                st.push(num.charAt(i));
            }
            i++;
        }
        
        while(!st.isEmpty() && k>0){
            st.pop();
            k--;
        }
        StringBuilder res = new StringBuilder();
        for(char c : st){
            res.append(c);
        }
        if(st.isEmpty()) return "0";
        else  return res.toString();




        
    }
}
