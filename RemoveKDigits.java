// Time Complexity : O(n), n -> length of string
// Space Complexity : O(n), stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:
// Since we need to remove k digits from the number in order to et smallest possible number, we will need to compare the current number with previous numbers. 
// Going back in the string for comparison is not desirable, therefore, a stack will be used for placing the numbers.
// Current number will be compared with previous numbers and if the previous numbers are greater than the current number, it will be popped from the stack. This operation will be done at max k times.
// edge cases needs to be taken care of such as trimming the leading zeroes before the result.

class Solution {
    public String removeKdigits(String num, int k) {
        // edge case
        if(num == null || k == 0) {
            return num;
        }
        
        StringBuilder result = new StringBuilder();
        Deque<Character> stack = new LinkedList<>();
        for(char ch : num.toCharArray()) {
            while(!stack.isEmpty() && stack.peek() > ch && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        while(!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }
        boolean flag = true;
        while(!stack.isEmpty()) {
            char ch = stack.removeLast();
            if(ch != '0' && flag)
                flag = false;
            if(!flag)
                result.append(ch);
        }
        if(result.length() == 0)
            return "0";
        return result.toString();
        
    }
}

