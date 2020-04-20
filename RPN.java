# Time complexity:O(n)
# Space complexity: 0(1)
# Did code run successfully on leetcode: yes
# Any problem you faced: No







class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();


        for(int i = 0; i < tokens.length; i++){

            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("/") || tokens[i].equals("*")){
               int a = Integer.valueOf(stack.pop());
               int b = Integer.valueOf(stack.pop());

            if(tokens[i].equals("+")){
                stack.push(a+b);
            }

            else if(tokens[i].equals("-")){
                stack.push(b-a);
            }

            else if(tokens[i].equals("/")){
                stack.push(b/a);
            }
            else {
                stack.push(b*a);
            }

            }
            else{
                stack.push(Integer.valueOf(tokens[i]));
            }

            }
            return stack.pop();

    }
}