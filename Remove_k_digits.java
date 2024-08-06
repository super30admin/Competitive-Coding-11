// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nos

class Solution {
    public String removeKdigits(String num, int k) {
        Stack <Character> s = new Stack<>();
        for(Character n : num.toCharArray()){
            while(!s.isEmpty() && k>0 && s.peek()> n){
                System.out.println(n);
                s.pop();
                k--;
            }
            
            s.push(n);
        }

        // Remove remaining elements
        while(k>0 && !s.isEmpty()){
            s.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            sb.append(s.pop());
        } 
        sb.reverse();

        //Remove leading zeros
        while(sb.length()>0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        // case when result is empty
        return sb.length() > 0 ? sb.toString() : "0";
    }
}