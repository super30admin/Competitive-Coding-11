// Time: O(n)
// Space: O(n)
// Idea here is to maintain a stack of integers to pop 2 most recent numbers whenever an operation
// is encountered. The result is then pushed to stack so that next operation
// can be performed on calculated value.
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("*");
        set.add("+");
        set.add("-");
        set.add("/");
        for(int i=0; i< tokens.length; i++) {
            if(set.contains(tokens[i])) {
                int first = st.pop();
                int second = st.pop();
                if(tokens[i].equals("*")) st.push(second*first);
                else if(tokens[i].equals("+")) st.push(second+first);
                else if(tokens[i].equals("-")) st.push(second-first);
                else st.push(second/first);
            } else {
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
}