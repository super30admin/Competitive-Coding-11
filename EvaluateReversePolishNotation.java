Time Complexity = O(n)
Space Complexity = O(n)

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int m=0; m < tokens.length;m++){
            String i = tokens[m];
            if(i.equals("+") || i.equals("-") || i.equals("/") ||i.equals("*") ){
                int k = stack.pop();
                int j = stack.pop();
                if(i.equals("+")){
                    stack.push(k+j);
                }else if(i.equals("-")){
                    stack.push(j-k);
                }else if(i.equals("*")){
                    stack.push(k*j);
                }else if(i.equals("/")){
                    stack.push(j/k);
                }     
            }else{
                stack.push(Integer.parseInt(i));
            }
        }
        return stack.pop();
    }
}