// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//TC:O(N*M)
//SC:O(N)
import java.util.*;

class Problem1 {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length();
        int[] match = new int[n];
        Arrays.fill(match, -1);

        // Mark the indices where replacements are possible
        for (int i = 0; i < indices.length; i++) {
            int index = indices[i];
            if (s.startsWith(sources[i], index)) {
                match[index] = i; // Store the index of the source-target pair
            }
        }

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < n) {
            if (match[i] != -1) {
                // If a replacement is possible
                int idx = match[i];
                result.append(targets[idx]);
                i += sources[idx].length(); // Skip over the replaced portion
            } else {
                // If no replacement is possible, append the original character
                result.append(s.charAt(i));
                i++;
            }
        }

        return result.toString();
    }
}

