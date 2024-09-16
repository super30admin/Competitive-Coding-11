// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();

            //iterate over tokens
            for(String token:tokens){

                //check if token is not an operator then perform operation on operands
                if(token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-")){

                    int res = 0;
                    int num2 = stack.pop();
                    int num1 = stack.pop();

                    switch(token){
                        case "*":
                            res = num1 * num2;
                            break;
                        case "/":
                            res = num1 / num2;
                            break;
                        case "+":
                            res = num1 + num2;
                            break;
                        case "-":
                            res = num1 - num2;
                            break;
                    }
                    stack.push(res);//push result to stack
                }else{
                    stack.push(Integer.valueOf(token));//push operand on to stack
                }
            }
            return stack.pop();//pop top of stack as final result
        
    }
}