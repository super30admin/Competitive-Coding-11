package competitiveCoding11;

import java.util.Stack;

public class RemoveKDigits {
	//Time Complexity : O(n), where n is the length of num
	//Space Complexity : O(n)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public String removeKdigits(String num, int k) {
        // null
        if(num == null || num.length() == 0)
            return "";
        if(k == 0)
            return num;
        
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<num.length(); i++) {
            while(!stack.isEmpty() && (stack.peek() - '0' > num.charAt(i) - '0') && k > 0) {
                stack.pop();
                k--;
            }
            if(num.charAt(i) != '0' || (k == 0 && !stack.isEmpty()))
                stack.push(num.charAt(i));
        }
        
        while(k-- > 0 && !stack.isEmpty())
            stack.pop();
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        
        sb = sb.reverse();
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
