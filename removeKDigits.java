// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
 * Create an increasing monotonic stack and iterate over the string.
 * If the incoming number is greater than the peek of stack, push the current number to stack.
 * Else pop the element from stack and decrement the k value, since we remove one element.
 * Untill k becomes zero perform this operation. 
 * If k becomes zero all remainging numbers to the stack.
 * check for leading zeroes and if stack becomes empty return 0.
 * If iterating over string is complete and k > 0, pop all the elements from stack until k becomes zero.
 * The result will give smallest number after removing k digits.
 */

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(num.charAt(0) - '0');
        int n = num.length();

        for(int i=1; i<n; i++){
            char ch = num.charAt(i);
            int curr = ch - '0';
            while(!st.isEmpty() && st.peekLast() > curr && k > 0){
                st.removeLast();
                k--;
            }
            st.offerLast(curr);
        }

        while(!st.isEmpty() && k > 0){
            st.removeLast();
            k--;
        }

        String result = "";
        while(!st.isEmpty() && st.peekFirst() == 0){
            st.pollFirst();
        }

        while(!st.isEmpty()){
            result += st.pollFirst();
        }

        return result.length() == 0 ? "0" : result;
    }
}