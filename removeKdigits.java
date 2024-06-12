// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
class Solution {
    public String removeKdigits(String num, int k) {
        if (k == 0) return num;
        StringBuilder sb = new StringBuilder(num);
        int i = 0;
        while (k > 0 && i < sb.length()) {
            if (i == sb.length() - 1 || sb.charAt(i + 1) < sb.charAt(i)) {
                sb.delete(i, i + 1);
                if (i > 0) i--;
                k--;
            } else {
                i++;
            }
            while (sb.length() > 0 && sb.charAt(0) == '0') {
                sb.delete(0, 1);
            }
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
