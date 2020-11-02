//Time Complexity: O(n)
//Space Complexity: O(n)
//Did it run on leetcode: yes
/** Approach: used a stack. if the token is number push into stack else if it is a operator pop first two elements of stack and apply the operator and push back into stack **/ 

class Solution {
    public int evalRPN(String[] tokens) {
        
        HashSet<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<tokens.length; i++){
            String curr = tokens[i];
            if(!set.contains(tokens[i]))
                stack.push(Integer.parseInt(tokens[i]));
            else{
                int num2 = stack.pop();
                int num1 = stack.pop();
                String op = tokens[i];
                if(op.equals("+")){
                    stack.push(num1+num2);
                }else if(op.equals("-")){
                    stack.push(num1-num2);
                }else if(op.equals("*")){
                    stack.push(num1*num2);
                }else{
                    stack.push(num1/num2);
                }
            }
            
        }
        
        return stack.peek();
    }
}
