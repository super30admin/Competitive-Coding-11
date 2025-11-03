// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Using monotonic increasing stack we can achieve this
//Keeping pushing the number to stack until the top of stack is greater than the number
//Pop the peek element and decrease the k count by 1
//when k becomes 0 stop popping the elements and add remaining elements to stack
//Append the stack elements to String and return it.
class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length())
            return "0";
        Stack<Character> st = new Stack<>();
        for (char n : num.toCharArray()) {
            while (!st.isEmpty() && k > 0 && st.peek() > n) {
                st.pop();
                k--;
            }
            st.push(n);
        }
        //when k is still left pop from end
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();

        for (char c : st)
            sb.append(c);
        //if 0 is present at start, trim it
        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);

        return sb.length() == 0 ? "0" : sb.toString();

    }
}
