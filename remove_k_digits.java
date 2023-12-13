// Time Complexity : O(NxK)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public String removeKdigits(String num, int k) {
        char[] chars = num.toCharArray();
        int n = k;
		if(num.length() <= k) return "0";
		int j = -1 ; int start = 0;
		for(int i = 0; i < num.length(); i++){
			while(j >= 0 && chars[j] > chars[i] && k > 0){
				j--;
				k--;
			}
			j++;
			chars[j] = chars[i];
		}
		while(start <= j  && chars[start] == '0') start++;
		String result="";
		for(int i = start ; i < num.length() - n ; i++)
			result = result + chars[i];

		if(result == "") return "0";
		return result;
    }
}