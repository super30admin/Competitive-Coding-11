// Time Complexity : O(n)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//https://leetcode.com/problems/evaluate-reverse-polish-notation/description/


public class Solution {
    public int EvalRPN(string[] tokens) {
        Stack<int> stack = new Stack<int>();

        foreach(var token in tokens){
            if(int.TryParse(token, out int number)){
                stack.Push(number);
            }else{
                int b = stack.Pop();
                int a = stack.Pop();
                stack.Push(token switch{
                    "+" => a +b,
                    "-" => a-b,
                    "*" => a*b,
                    "/" => a/b
                });
            }

        }
        return stack.Pop();
    }
}