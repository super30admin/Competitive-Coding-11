package CompetitiveCoding11;

import java.util.LinkedList;

public class RemoveKDigits {

    /* Created by palak on 8/8/2021 */

    /**
     TC: O(n)
     SC: O(n)
     */
    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<Character>();

        for(char digit : num.toCharArray()) {
            while(stack.size() > 0 && k > 0 && stack.peekLast() > digit) {
                stack.removeLast();
                k -= 1;
            }
            stack.addLast(digit);
        }

        /* remove the remaining digits from the tail. */
        for(int i = 0; i < k; i++) {
            stack.removeLast();
        }

        // build the final string, while removing the leading zeros.
        StringBuilder result = new StringBuilder();
        boolean leadingZero = true;
        for(char digit: stack) {
            if(leadingZero && digit == '0') continue;
            leadingZero = false;
            result.append(digit);
        }

        /* return the final string  */
        if (result.length() == 0) return "0";
        return result.toString();
    }

    public static void main(String[] args) {

    }
}
