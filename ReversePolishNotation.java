//TC : O(N)
//SC : O(N) for stack


class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0)    return 0;
        Stack<Integer> stack = new Stack<>();
        HashSet<String> set = new HashSet<>();
        
        set.add("+"); set.add("-"); set.add("*"); set.add("/"); //Adding operators in hashset
         
        for(String s : tokens){ //Iterating over Tokens
            if(set.contains(s)){ // If given token is operator which is in the set
                int b = stack.pop();
                
                int a = stack.pop();
                
                if(s.equals("+")){
                    stack.push(a + b);
                }else if(s.equals("-")){
                    stack.push(a - b);
                }else if(s.equals("*")){
                    stack.push(a * b);
                } else if(s.equals("/")) {
                    stack.push(a / b);
                }
            }
            else{ // jjust push the operand to stack
                stack.push(Integer.parseInt(s));
            }
    }
        
    return stack.pop(); //only one value will be in the stack, pop it and return it

    }
}