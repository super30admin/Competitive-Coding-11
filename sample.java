// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == 0) {
            return num;
        }
        if (num.length() == k) {
            return "0";
        }
        Stack<Integer> s = new Stack<>();
        for (int i=0;i<num.length();i++) {
            char c = num.charAt(i);
            while( k > 0 && !s.isEmpty() && s.peek() > (c-'0') ) {
                s.pop();
                k--;
            }
            s.push(c-'0');
        }
        StringBuilder sb = new StringBuilder("");
        System.out.println(k);
        while (k>0) {
            s.pop();
            k--;
        }
        while(!s.isEmpty()) {
            sb.append(s.pop());
        }
        StringBuilder result = new StringBuilder(sb.reverse());
        System.out.println(result);
        int i=0;
        while ( result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        return result.toString();
    }
}
