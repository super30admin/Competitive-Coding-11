class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0; //if there are no tokens or the length of tokens is 0 we return 0

        HashSet<String> set = new HashSet<>(); //we initialize a hashset with name set
        Stack<Integer> stack = new Stack<>(); //we initialize a stack with name stack

        //we add the operands to the set to later check with them
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");

        for(String s : tokens) { //we go through all the elements present in tokens
            if(set.contains(s)) { //if set contains the element s
                //we are initializing 2 variables which stores the elements we get from stack
                int first = stack.pop();
                int second = stack.pop();

                //we are check if s is either of the operand and we perform respective actions
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

            else { //if set dosent contains s
                stack.push(Integer.parseInt(s)); //we add s to check after parsing if it is an integer
            }
        }
        return stack.pop(); //in the end, we return the answer by popping the leftover element
    }
}
//tc and sc - O(N)