// Time Complexity : O(n*k)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach
// Greedy
class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() <= k){
            return "0";
        }
        
        int i=0;
        StringBuilder result = new StringBuilder();
        while(i < num.length()){
            char curr = num.charAt(i);
            while(k>0 && result.length()!=0 && curr<result.charAt(result.length()-1)){
                k--;
                result.deleteCharAt(result.length()-1);
            }
            
            if(curr!='0' || result.length()!=0){
                result.append(curr);
            }
            i++;
        }

        while(k>0){
            k--;
            result.deleteCharAt(result.length()-1);
        }
        return result.length()==0 ? "0" : result.toString();
        
    }
}
