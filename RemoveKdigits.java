// Time Complexity : The time complexity is O(n) where n is the length of the string
// Space Complexity : The space complexity is O(n) where n is the length of the string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public String removeKdigits(String num, int k) {

        if(num == null || num.length() == 0 || num.length() == k){
            return "0";
        }

        Stack<Character> s = new Stack<>();

        // find the first k digits to remove
        for(int i=0;i<num.length();i++){
            char ch = num.charAt(i);
            while(k >0 && !s.isEmpty() && s.peek() > ch){
                s.pop();
                k--;
            }
            s.push(ch);
        }

        while(k>0){
            s.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        // form the output string
        while(!s.isEmpty()){
            char ch = s.pop();
            sb.append(ch);
        }

        sb.reverse();

        //remove preceding zeroes
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        return sb.toString();

    }
}
