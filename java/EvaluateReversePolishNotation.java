Evaluate Reverse Polish Notation
        Evaluate the value of an arithmetic expression in Reverse Polish Notation.

        Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

        Note that division between two integers should truncate toward zero.

        It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.



        Example 1:

        Input: tokens = ["2","1","+","3","*"]
        Output: 9
        Explanation: ((2 + 1) * 3) = 9
        Example 2:

        Input: tokens = ["4","13","5","/","+"]
        Output: 6
        Explanation: (4 + (13 / 5)) = 6

Tc: O(n) where n is the length of the tokens provided
Sc: O(n) stack space

class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens==null || tokens.length==0) return 0;

        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            if("+-*/".contains(token)){
                int y = stack.pop();
                int x = stack.pop();
                int result = 0;
                switch(token){
                    case "+":
                        result = x+y;
                        break;
                    case "-":
                        result = x-y;
                        break;
                    case "*":
                        result = x*y;
                        break;
                    case "/":
                        result = x/y;
                        break;

                }
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
