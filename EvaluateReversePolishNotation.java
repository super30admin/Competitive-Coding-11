//Time Complexity O(N)
//Space Complexity O(N)
//Leetcode tested

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        for(String s : tokens){
            if(set.contains(s)){
                int first = stack.pop();
                int second = stack.pop();

                if(s.equals("+")){
                    stack.push(second+first);
                }
                else if(s.equals("-")){
                    stack.push(second-first);
                }
                else if(s.equals("*")){
                    stack.push(second*first);
                }
                else if(s.equals("/")){
                    stack.push(second/first);
                }

            }else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
}
