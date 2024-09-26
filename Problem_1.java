// Time complexity - O(n)
// Space complexity - O(n)

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack();
        for(char digit : num.toCharArray()) {
            while(stack.size() > 0 && k > 0 && stack.peek() > digit) {
                stack.pop();
                k -= 1;
            }
            stack.push(digit);
        }
        /* remove the remaining digits from the tail. */
        for(int i=0; i<k; ++i) {
            stack.pop();
        }
        
        // build the final string, while removing the leading zeros.
        StringBuilder result = new StringBuilder();
        boolean leadingZero = true;
        for(char digit: stack) {
            if(leadingZero && digit == '0') continue;
            leadingZero = false;
            result.append(digit);
        }
        if (result.length() == 0) return "0";
        return result.toString();   
        }
}
