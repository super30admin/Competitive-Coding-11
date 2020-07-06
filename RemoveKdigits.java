//Time Complexity : O(2n)
// Space Complexity : O(n)  stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : What should we do if we FORGET some Java syntax such as Trimming leading 0's built in function, Regular expression, etc in interviews?
/* Your code here along with comments explaining your approach: We need a monotonically increasing series in the stack. If the stack top is 
greater than the incoming element, pop till the element becomes strictly smaller decrementing the k value as we are removing digits. If the sequence
is in strictly increasing order, and after the operations, k still is > 0, then till k becomes 0 , remove the last k digits. Push the remaining 
content from the stack to stringbuilder and represent the result.
*/
class Solution {
    public String removeKdigits(String num, int k) {
        if(num == null || num.length() == 0) return "0";
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < num.length(); i++){
            int c = (int) (num.charAt(i) - '0');                                            // Character to integer
            while(!stk.empty() && k > 0 && stk.peek() > c){                 // Compare with top of the stack and incoming element
                stk.pop();          
                k--;                                                                        // Reduce the k value by 1 each time a pop occurs
            }
            stk.push(c);                                                                    // Push the digits in stack
        }   
            while(!stk.empty() && k > 0){   
                stk.pop();                                                                      // Remove the remaining k digits from the end
                k--;
            }
            StringBuilder sb = new StringBuilder();
             if(stk.empty()){stk.push(0);}                                                  // If stack is empty return a 0
            while(!stk.isEmpty()){
                String s = stk.pop().toString();                                            // Push the number from stack to the result stringbuilder
                sb.append(s); 
            }
       return sb.reverse().toString().replaceFirst("^0+(?!$)", "");                                     // Represent the reverse of the stringbuilder and trim the leading 0's
    }
}