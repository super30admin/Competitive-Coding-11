// Time Complexity : O(Nk)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public String removeKdigits(String num, int k) {
        if (k > num.length())
            return "0";
        
        StringBuilder sb = new StringBuilder(num);

        for (int j = 0; j < k; j++) {
            int i = 0;
            while (i < sb.length() - 1 && sb.charAt(i) <= sb.charAt(i + 1)) {
                i++;
            }
            sb.delete(i, i + 1);
        }
        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);

        if (sb.length() == 0) {
            return "0";
        }

        return sb.toString();
    }
}
