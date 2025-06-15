import java.util.Stack;

public class problem2 {
    // TC: O(n)
    //SC: O(n)
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack= new Stack<>();
        for(String ele: tokens)
        {
            if (ele.equals("+") || ele.contains("-") || ele.contains("/") || ele.contains("*"))
            {
                int num2= stack.pop();
                int num1= stack.pop();
                int res=0;

                switch (ele)
                {
                    case "+":
                        res=num1+num2;
                        break;

                    case "-":
                        res= num1-num2;
                        break;

                    case "/":
                        res= num1/num2;
                        break;

                    case "*":
                        res= num1*num2;
                        break;
                }
                stack.push(res);
            }
            else {
                stack.push(Integer.parseInt(ele));
            }
        }
        return stack.pop();
    }
}
