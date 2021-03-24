//Stack
//TC: O(N)
//SC: O(N)
// Did it run successfully on Leetcode? : Yes
class Solution {
    public int evalRPN(String[] tokens) {
        HashSet<String> set = new HashSet();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        Stack<Integer> stack = new Stack();
        for (String token : tokens){
            if (set.contains(token)){
                    int second = stack.pop();
                    int first = stack.pop();
                    if (token.equals("+")){
                        stack.push(first + second);
                    }
                    else if (token.equals("-")){
                        stack.push(first - second);
                    }
                    else if (token.equals("*")){
                        stack.push(first * second);
                    }
                    else if (token.equals("/")){
                        stack.push(first / second);
                    }
                }
            else{
                 stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
