// Approach : since we need to go back and get the previous operands when you encounter an operator. So we need a stack.
// Time : O(n)
// Space : O(n)
class Solution {
    public int evalRPN(String[] tokens) {
       Stack<Integer> stk = new Stack<>();
       for(String token:tokens){
        if(!"*/+-".contains(token)){
            stk.push(Integer.parseInt(token));
            continue;
        }
        int result=0;
        int number2=stk.pop();
        int number1=stk.pop();
        switch (token) {
            case "+":
                result=number1 + number2;
                break;
            case "-":
                result=number1 - number2;
                break;
            case "*":
                result=number1 * number2;
                break;
            case "/":
                result=number1 / number2;
                break;
        }
        stk.push(result);
       } 
       return stk.peek();
    }
}