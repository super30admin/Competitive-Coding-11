/**
 * Approach: The idea is to iterate through the array and identify whether its an operator or an operant
 * If its an operand, add it to the stack
 * if its an operator,
    - for + and *, eval ans and add it to the stack
    - for - & /, as stack is LIFO, we need to flip the numbers before performing the operation and push the ans to the stack
* lastly, return the top of the stack
 */
//TC: O(n) -> iterate through tokens array
//SC: O(n) -> stack for maintaining the operands
class Solution {
    public int evalRPN(String[] tokens) {       
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num1+num2);
            }
            else if(tokens[i].equals("-")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2-num1);
            }
            else if(tokens[i].equals("*")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num1*num2);
            }
            else if(tokens[i].equals("/")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2/num1);
            }
            else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        
        } 
        return stack.pop();
    }
}

