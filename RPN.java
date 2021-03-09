class Solution {
    public int evalRPN(String[] tokens) {
        // Reverse Polish Notation
        if(tokens == null || tokens.length == 0) return 0;
        // We are using a stack
        //Everytime we meet an operand, we need to check if previous two are integers.
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < tokens.length; i++){
            //Check if it is an operand
            //Pop the two items under, should be ints
            String currentStr = tokens[i];
            if(currentStr.equals("+") || currentStr.equals("*") || currentStr.equals("-") || currentStr.equals("/")){
                Integer two = stack.pop();
                Integer one = stack.pop();
                if(currentStr.equals("+")){
                    stack.push(one+two);
                }else if(currentStr.equals("-")){
                    stack.push(one-two);
                }else if(currentStr.equals("*")){
                    stack.push(one*two);
                }else if(currentStr.equals("/")){
                    stack.push(one/two);
                }
            }else{
                Integer toAdd = Integer.parseInt(currentStr);
                stack.push(toAdd);
            }
        }
        return stack.pop();
    }
}