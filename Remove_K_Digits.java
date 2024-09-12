import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        //edge case
        if(num == null || num.length() == 0)
            return num;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<num.length();i++)
        {
            while(!stack.isEmpty() && stack.peek() > num.charAt(i) && k > 0)
            {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        StringBuilder str = new StringBuilder();
    
        while(!stack.isEmpty() && k > 0)
        {
            k--;
            stack.pop();
        }
        while(!stack.isEmpty())
        {
            str.append(stack.pop());
        }
        str.reverse();
        
        while(str.length() != 0 && str.charAt(0) == '0')
        {
            str.deleteCharAt(0);
        }
        return (str.length() != 0) ? str.toString(): "0" ;
    }
}

//Time complexity: O(n)
//Space Complexity : O(n) for the string builder