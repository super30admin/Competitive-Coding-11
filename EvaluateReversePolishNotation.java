/*
 * TC  = O(N)
 * SC  = O(N)
 * 
 * Approach: We push all the integers in stack. 
 * Whenever we need to perform arithematic operation, we pop the first two elements, compute the answer
 * and then push it to the stack.
 */

import java.util.*;
public class EvaluateReversePolishNotation
{
    public static int eval(String[] s)
    {
        if(s == null || s.length == 0) return 0;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i<s.length;i++)
        {
            String curr = s[i];

            if(curr == "+")
            {
                stack.push(stack.pop()+stack.pop());
            }
            else if(curr == "-")
            {
                int two = stack.pop();
                int one = stack.pop();

                stack.push(one - two);
            }
            else if(curr == "/")
            {
                int two = stack.pop();
                int one = stack.pop();

                stack.push(one/two);
            }
            else if(curr == "*")
            {
                stack.push(stack.pop()*stack.pop());
            }
            else
            {
                stack.push(Integer.parseInt(curr));
            }
        }

        return stack.peek();
    }

    public static void main(String args[])
    {
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(eval(tokens));
    }
}