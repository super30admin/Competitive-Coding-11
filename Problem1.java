// Time Complexity : O(N)
// Space Complexity : O(N)
//Problem: https://leetcode.com/problems/remove-k-digits/

class Solution {

    Stack<Character> st = new Stack<>();

    public String removeKdigits(String num, int k) {

        st.push(num.charAt(0));

        for(int i=1;i<num.length();i++){

            while(!st.isEmpty() && k> 0 && st.peek() > num.charAt(i)){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }

        for(int i=0; i<k; ++i) {
            st.pop();
        }


        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        StringBuilder sc = sb.reverse();
        int l = 0;

        for(int i=0;i<sc.length();i++){
            if(sc.charAt(i) == '0'){
                l++;
            }else{
                break;
            }
        }

        sc.delete(0, l);
        if(sc.length() == 0){
            return "0";
        }else
            return sc.toString();
    }
}
