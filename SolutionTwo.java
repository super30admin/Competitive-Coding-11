// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : nopes

class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<Character>();

        for(char digit : num.toCharArray())
        {
            while(stack.size() > 0 && k > 0 && stack.peek() > digit)
            {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        /* remove the remaining digits from the tail. */
        for(int i=0; i<k; ++i)
        {
            stack.pop();
        }

        // build the final string, while removing the leading zeros.
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        for(char digit: stack)
        {
            if(leadingZero && digit == '0')
                continue;
            leadingZero = false;
            ret.append(digit);
        }

        /* return the final string  */
        if (ret.length() == 0) return "0";
        return ret.toString();

    }
}