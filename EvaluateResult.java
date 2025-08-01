// Time complexity - O(n)
// Space - O(k)
// Solved on leetcode - yes
// faced any issues - No
class Solution {
    public int evalRPN(String[] token) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<token.length; i++) {
            if(token[i].equals("+") || token[i].equals("-") || token[i].equals("*") || token[i].equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                if (token[i].equals("+"))
                    stack.push(b + a);
                else if (token[i].equals("-"))
                    stack.push(b - a);
                else if (token[i].equals("*"))
                    stack.push(b * a);
                else if (token[i].equals("/"))
                    stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(token[i]));
            }
        }
        return  stack.peek();
    }
}
