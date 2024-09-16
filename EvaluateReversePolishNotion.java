// Time Complexity : O(n)
// Space Complexity : O(1)
// Did it run of Leetcode: yes

import java.util.HashSet;
import java.util.Stack;

public class EvaluateReversePolishNotion {

    public int evalRPN(String[] tokens) {

        HashSet<String> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");

        for(String s : tokens) {
            if(set.contains(s)) {

                int first = stack.pop();
                int second = stack.pop();

                if(s.equals("+")) {
                    stack.push(second + first);
                }
                else if(s.equals("-")) {
                    stack.push(second - first);
                }
                else if(s.equals("*")) {
                    stack.push(second * first);
                }
                else if(s.equals("/")) {
                    stack.push(second / first);
                }
            }

            else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
