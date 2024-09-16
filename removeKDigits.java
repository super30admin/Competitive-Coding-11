// Time Complexity : O(N) 
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
1. Divided the problem into subproblems and if the value is a palindrome add to final arraylist
*/


// Your code here along with comments explaining your approach
class Solution {
    public String removeKdigits(String num, int k) {
        if(k == 0) return num;
        if(k == num.length()) return "0";
        int removeCount = k;
        List<Integer> queue = new ArrayList<>();
        for(int i=0;i<num.length();i++) {
            char c = num.charAt(i);
            int curr = Integer.parseInt(String.valueOf(c));
            if(queue.size() != 0) {
                if(curr < queue.get(queue.size()-1)) {
                    if(removeCount > 0) {
                        queue.remove(queue.size()-1);
                        removeCount--;
                    }
                    queue.add(curr);
                } else {
                    queue.add(curr);
                }
            } else {
                queue.add(curr);
            }
        }
        
        while(removeCount > 0) {
            queue.remove(queue.size()-1);
            removeCount--;
        }
        System.out.println(Arrays.toString(queue.toArray()));
        return convertToString(queue);
    }
    
    public String convertToString(List<Integer> q) {
        String ans = "";
        boolean foundNonZeroNum = false;
        for(int i=0;i<q.size();i++) {
            if(q.get(i) > 0) {
                foundNonZeroNum = true;
            }
            
            if(foundNonZeroNum) {
                foundNonZeroNum = true;
                ans = "";
                ans += q.get(i);
            }
        }
        return ans == "" ? "0" : ans;
    }
}
