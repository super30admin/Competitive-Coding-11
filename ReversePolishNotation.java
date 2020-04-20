//o(n) time and o(n) space
//passed all leetcode cases
//used stack approach


class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("/");
        set.add("-");
        set.add("*");
        for(String s: tokens){
            if(set.contains(s)){
                int first = stack.pop();
                int second = stack.pop();
                if(s.equals("+")) stack.push(second+first);
                if(s.equals("/")) stack.push(second/first);
                if(s.equals("-")) stack.push(second-first);
                if(s.equals("*")) stack.push(second*first);
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}