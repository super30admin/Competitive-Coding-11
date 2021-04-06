// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack();
        for(char digit : num.toCharArray()) {//storing all the number which are not reater than previous value
            while(stack.size() > 0 && k > 0 && stack.peek() > digit) {
                stack.pop();
                k -= 1;
              }
            stack.push(digit);
        }

        for(int i=0; i<k; ++i) {
          stack.pop();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        for(char digit: stack) {
          if(leadingZero && digit == '0') continue;//not considering leading 0
          leadingZero = false;
          ret.append(digit);
        }

        if (ret.length() == 0) return "0";
        return ret.toString();
    }
}