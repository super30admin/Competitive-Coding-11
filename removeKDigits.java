// TC - O(n) - only 1 traversal through the entire string's chars
// SC - O(n) - for the stack

/*
 * Approach:
 * We use a monotonic increasing stack that will contain n-k elements of the 
 * answer in reverse but increasing order (since the problem is basically to 
 * find the increasing subsequence after removing k elements).
 */

import java.util.Stack;
class Solution {
    public String removeKdigits(String num, int k) {
        if(num == null || num.length() == 0 || k == 0) {
            return num;
        }

        int n = num.length();

        if(n <= k) { // case where we remove all digits
            return "0";
        }

        // monotonic increasing stack that will contain n-k elements of the answer (in reverse)
        Stack<Character> s = new Stack<>();

        for(int i=0; i<n; i++) { // start building increasing sequence of digits
            // remove all elements until either 
            //      k is exhausted or 
            //      all elements are exhausted or
            //      current element is > prev elements (i.e., stack elements)
            while(k > 0 && !s.isEmpty() && s.peek() > num.charAt(i)) {
                s.pop();
                k--; // count this removal towards final count
            }

            s.push(num.charAt(i));
        }

        // then deal with case of increasing digits, remove other pending elements
        while(k-- > 0 && !s.isEmpty()) {
            s.pop();
        }

        StringBuilder res = new StringBuilder(); // to reverse stack and provide result
        while(!s.isEmpty()) {
            res.append(String.valueOf(s.pop()));
        }

        res.reverse(); // we popped in reverse order, so we need to reverse the string

        while(res.length() > 0 && res.charAt(0) == '0') {
            res.deleteCharAt(0); // remove all starting 0's
        }

        if(res.length() == 0) return "0";

        return res.toString();
    }
}