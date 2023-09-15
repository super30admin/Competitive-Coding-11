// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stk = new Stack<>();
        if(num.length() == k) return "0";

        //Push numbers in stack and when we get a smaller number , pop numbers from stack
        for(int i=0; i<num.length(); i++){
            int temp = num.charAt(i) - '0';
            while(!stk.isEmpty() && k>0 && stk.peek()>temp){
                stk.pop();
                k--;
            }
            stk.push(temp);
        }

        //If remaining k is still there, pop from stack
        while(k>0){
            stk.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            int c= stk.pop();
            sb.append(c);
        }

        sb.reverse();

        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        return sb.toString();

    }
}