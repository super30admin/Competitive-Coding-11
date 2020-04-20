// Time Complexity : O(N) ietrating over the elements once. While checking for k, in worst case k can be equal to N. Therefore, O(2N)
// Space Complexity : O(N), if we take stringbuilder into consideration
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : How to handle leading zeros


// Your code here along with comments explaining your approach
//Basically check whether the current element is greater than the next element. If yes, then delete the current element. You can either use a stack to store the current element or
//can use a string builder to append element and use it's last element as current. We keep on removing current element until a next greater or equal element is found.

//If we iterated over al elements and still k is not 0, then we start deleting from end.
//Take care of leading zeros. Keep deleting the first character from string builder if it is equal to '0' and while string builder length is > 0.
//Return the string builder.


class Solution {
    public String removeKdigits(String num, int k) {

        if(k >= num.length()) return "0";
                
        int count = 0;
        int n = num.length();
        
        StringBuilder sb = new StringBuilder();
        
        //put elements inside stringbuilder
        while(count < n){
            while(k >0 && sb.length()>0 &&  sb.charAt(sb.length()-1) > num.charAt(count)){
              sb.deleteCharAt(sb.length()-1);  
                k--;
            }
            sb.append(num.charAt(count));
            System.out.println(sb.toString());
            count++;
        }
        
        //if we iterated over all the elements and still k is 0, then start deleting from back
        while(k>0 && sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
            k--;
        }
        
        //check for leading zeros
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
}
