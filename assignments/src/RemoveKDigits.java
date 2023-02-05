// Approach: Create and maintain a monotonic increasing stack with all digits in num
// Keep removing elements if greater than ones inside stack
// Time: O(n)
// Space: O(n)

import java.util.Stack;

class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack();

        for(char digit : num.toCharArray()) {
            while(stack.size() > 0 && k > 0 && stack.peek() > digit) {
                stack.pop();
                k -= 1;
            }
            stack.push(digit);
        }

        // remove the remaining digits from the tail.
        for(int i=0; i<k; ++i) {
            stack.pop();
        }

        // build the final string, while removing the leading zeros.
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        for(char digit: stack) {
            if(leadingZero && digit == '0') continue;
            leadingZero = false;
            ret.append(digit);
        }

        if (ret.length() == 0) return "0";
        return ret.toString();
    }
}