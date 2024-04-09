class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i =0; i<tokens.length;i++) {
            String value = tokens[i];
            if(value.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a+b);
            } else if(value.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a-b);
            } else if(value.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a*b);
            } else if(value.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a/b);
            }else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}