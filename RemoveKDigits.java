/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Yes, the boundary cases were too complex to handle
*/
public class RemoveKDigits
{
    public String removeKdigits(String num, int k)
    {

        Stack<Integer> stack = new Stack<>();

        for(int i =0; i< num.length(); i++)
        {
            char ch = num.charAt(i);
            int currentValue = ch - '0';

            while(k > 0 && !stack.isEmpty() && stack.peek() > currentValue)
            {
                stack.pop();
                k--;
            }

            stack.push(currentValue);
        }

        while(k > 0)
        {
            stack.pop();
            k--;
        }

        StringBuffer sb = new StringBuffer();

        while(!stack.isEmpty())
        {
            sb.append(stack.pop());
        }

        sb.reverse();

        while(sb.length() > 0 && sb.charAt(0) == '0')
        {
            sb.deleteCharAt(0);
        }

        String output = sb.toString();

        if(output.length()==0)
            return "0";

        return output;
    }
}