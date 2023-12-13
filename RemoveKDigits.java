// Time Complexity : O(n)
// Space Complexity : O(n)
// n is the length of given input logs
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approac

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st= new Stack<>();
        st.push(num.charAt(0));

        for(int i = 1 ; i < num.length() ; i++){

            while(!st.isEmpty() && st.peek() > num.charAt(i) && k > 0){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }

        //while loop did not execute, we pushed eveythign to stack
        for(int i = 0 ; i < k ; i++){
            st.pop();
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        StringBuilder result = new StringBuilder();
        result = sb.reverse();

        //leading zero's
        int a = 0;
        for(int i = 0 ; i < result.length() ; i++){
            if(result.charAt(i) == '0'){
                a++;
            }
            else break;
        }

        result.delete(0,a);
        if(result.length() == 0){
            return "0";
        }
        else return result.toString();
    }
}