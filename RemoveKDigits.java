// Time Complexity : O(n) where n is the length of the string number
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * The solution is based on the approach that we remove the digits starting from the beginning as starting digits decide whether we get a higher number or not
 * We use stack to keep track of the last digit to compare with the current digit
 * Initialize the stack with the first digit
 * Initialize the cur pointer to 2nd digit
 * If cur is greater than or equal to last element(top of the stack), then we just increment cur index and push it on the stack
 * if cur is smaller thanlast element, we remove the element from stack top and decrement k.
 * 
 * Finally based on the remaining elements on the stack and the string, we construct the number in string format.
 */

class Solution {
    public String removeKdigits(String num, int k) {
        
        Stack<Integer> st = new Stack<Integer>();
        
        int cur = 1;
        
        st.push(Character.getNumericValue(num.charAt(0)));
        
        while(cur < num.length() && k > 0) {
            int cur_int = Character.getNumericValue(num.charAt(cur));
            if(st.isEmpty()) {
                
                st.push(cur_int);
                cur++;
            } else if(cur_int >= st.peek()) {
                st.push(cur_int);
                cur++;
            } else {
                // remove the previous element
                st.pop();
                
                // remove any 0s from beginning
                while(st.isEmpty() && cur < num.length() && num.charAt(cur) == '0') {
                    cur++;
                }
                k--;
            }
        }
        
        if(k > 0) {
            // Not all the required k numbers removed
            while(!st.isEmpty() && k > 0) {
                st.pop();
                k--;
            }
        }
        
        // construct the result
        
        String res = "";
        
        while(!st.isEmpty()) {
            res = st.pop() + res;
        }
        
        res += num.substring(cur);
        
        return res.equals("") ? "0" : res;
    }   
}