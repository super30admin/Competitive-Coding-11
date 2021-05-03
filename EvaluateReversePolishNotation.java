class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
            return 0;
        }
        
        int result = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        //if the string is operator, pop elements fron stack
        //perform operation and push result on to satck
        //if string encounterd is an integer value, push it on to stack
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+")){
                int op1 = stack.pop();
                int op2 = stack.pop();
                result = op2 + op1;
                stack.push(result);
            }else if(tokens[i].equals("-")){
                int op1 = stack.pop();
                int op2 = stack.pop();
                result = op2 - op1;
                stack.push(result);
            }else if(tokens[i].equals("*")){
                int op1 = stack.pop();
                int op2 = stack.pop();
                result = op2 * op1;
                stack.push(result);
            }else if(tokens[i].equals("/")){
                int op1 = stack.pop();
                int op2 = stack.pop();
                result = op2 / op1;
                stack.push(result);
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        
        //return the final result
        return (!stack.isEmpty()) ? stack.pop() : 0;
    }
}
//Time Complexity: O(n)
//Space Complexity: O(n)