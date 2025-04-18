import java.util.Stack;

/**
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * Using a monotonic decreasing stack to remove k larger number from the top of the stack
 */

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {// 1432219, 3
        if (num == null || num.length() == 0) {
            return num;
        }

        Stack<Integer> s = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char c: num.toCharArray()) { // 1432219
            int digit = c - '0';
            while (!s.isEmpty() && s.peek() > digit && k > 0) {
                s.pop(); // 4, 3, 2
                k--;
            }

            s.push(digit); // 1,2,1,9
        }

        // remove any remaining numbers from the top of the stack
        // (this would remove larger digits since this is a monotonic decreasing stack)
        while (k > 0 && !s.isEmpty()) {
            s.pop();
            k--;
        }        

        int size = s.size();

        // get items from stack
        for (int i = 0; i < size; i++) {
            result.append(s.pop());
        }

        int i = size - 1;
        // remove trailing 0s
        while (i >= 0 && result.charAt(i) == '0') {
            result.deleteCharAt(i);
            i--;
        }

        // Since the stack is read in LIFO order, reverse the result
        result.reverse();
        return result.length() > 0 ? result.toString() : "0";
    }

    public static void main(String[] args) {
        // Your code here
    }
}