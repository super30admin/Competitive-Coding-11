/*

https://leetcode.com/problems/assign-cookies/

Did it run on leetcode: yes
Problems Faced: No

Time Complexity: 0(MlogM + NLogN + min(M,N))
Space Complexity: 0(1)

Algorithm:
- Sort both the arrays
- In a greedy fashion try to satisfy the min greed of the child with the minimum cookie possible.


*/


class Solution {
    public int findContentChildren(int[] g, int[] s) {
        
        Arrays.sort(g);
        Arrays.sort(s);
        
        int childIndex=0,cookieIndex=0;
        
        while(childIndex<g.length && cookieIndex<s.length){
            if(g[childIndex]<=s[cookieIndex]){
                childIndex++;
            }
            
            cookieIndex++;
        }
        
        return childIndex;
        
    }
}