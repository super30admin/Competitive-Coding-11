// Time Complexity : O(n) n - length of input string
// Space Complexity : O(n) stack to store prev chars
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Traverse through the string, check if the prev integer char is higher remove from stack, and put the curr to stack
// After traversing if k digits is not yet  removed remove the top elements, i.e. all the higher digits are at the last 
// Or after removing if the output number has leading zeroes before remove using a flag


class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<num.length();i++){
            int c = (num.charAt(i)-'0');
            while(!st.isEmpty() && c < st.peek() && k>0){
                st.pop();
                k--;
            }
            st.push(c);
        }
        while(k > 0){
            st.pop();
            k--;
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        boolean flag = true;
        int ind = 0;
        sb.reverse();
        while(ind<sb.length()){
            if(sb.charAt(ind) != '0' && flag){
                flag = false;
                break;
            }
            ind++;
        }
        return sb.substring(ind,sb.length()).length() == 0? "0" : sb.substring(ind,sb.length()).toString();
    }
}
