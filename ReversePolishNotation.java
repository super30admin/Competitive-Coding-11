// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        HashSet<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");

        for(String token : tokens) {
            // digits pushing to stack
            if(!set.contains(token)) {
                System.out.println("token::"+token);
                st.push(Integer.valueOf(token));
                continue;
            }

            // if it is an operator

            int n1 = st.pop();
            System.out.println("n1::"+ n1);
            int n2 = st.pop();
            System.out.println("n2::"+ n2);
            int result=0;
            switch(token){
                case "+": result = n1 + n2;
                    break;
                case "-": result = n2 - n1;
                    break;
                case "*": result = n1 * n2;
                    break;
                case "/": result = n2 / n1;
                    break;
            }
            st.push(result);
        }

        return st.peek();
    }
}