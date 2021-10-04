//https://leetcode.com/problems/remove-k-digits/
/*
Time: O(n) where n = num.length()
Space: O(n) for Stack
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<Character>();

        // base condition
        if (k >= num.length())
            return "0";

        int i = 0;
        while (i < num.length()) {

            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop(); // you don't want the top as it is greater
                k--; // you have removed a digit, so do k--
            }

            stack.push(num.charAt(i)); // otherwise keep pushing number normally and increment index
            i++;

        }

        // corner case like "1111" // Or After traversing through all the digits, if k
        // is still > 0, remove remaining k digits
        while (k-- > 0)
            stack.pop();

        // pop and add to sb, reverse sb
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();

        // Now, Del any leading zeros are in string, if any
        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0); // or sb = sb.substring(1)

        return sb.toString();

    }

}
