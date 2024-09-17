class EvaluateReversePolishNotation {

    // Time Complexity: O(n)
    // Space Complexity: O(n)

    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0)
            return 0;

        Stack<Integer> stack = new Stack();
        
        for(String s : tokens){
            
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int curr = stack.pop();
                int next = stack.pop();
                char c = s.charAt(0);
                int result = 0;
                if(c == '+')
                    result = next + curr;
                else if(c == '-')
                    result = next - curr;
                else if(c == '*')
                    result = next * curr;
                else
                    result = next / curr;
                stack.push(result);
            }else                
                stack.push(Integer.parseInt(s));
        }
        return stack.pop();
    }
}