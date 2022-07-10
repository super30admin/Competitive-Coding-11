/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
public class ReversePolishEvaluation
{
    public int evalRPN(String[] tokens)
    {
        Stack<Integer> stack = new Stack<>();

        for(String input: tokens)
        {
            boolean isOperator = isOperator(input);

            if(isOperator)
            {
                // perform the operation
                int top1 = stack.pop();
                int top2 = stack.pop();

                int result = getResult(top2, top1, input);
                stack.push(result);
            }
            else
            {
                // push to stack
                stack.push(Integer.parseInt(input));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String input)
    {
        return input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/");
    }

    private int getResult(int top2, int top1, String operation)
    {
        switch (operation)
        {
            case "+":
                return top2 + top1;
            case "-":
                return top2 - top1;
            case "*":
                return top2 * top1;
            case "/":
                return top2 / top1;
        }

        return 0;
    }

    public static void main(String[] args)
    {
        ReversePolishEvaluation reversePolishEvaluation = new ReversePolishEvaluation();
        String input[] = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

        int result = reversePolishEvaluation.evalRPN(input);
        System.out.println("The result is : "+ result);

    }
}
