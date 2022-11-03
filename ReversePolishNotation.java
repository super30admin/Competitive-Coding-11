public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        // null case
        if(tokens==null || tokens.length==0) return 0;
        Stack<Integer> st = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        int result = 0;
        for(String str:tokens){
            if(set.contains(str)){
                int first = st.pop();
                int second = st.pop();
                if(str.equals("+"))
                    st.push(second+first);
                else if(str.equals("-"))
                    st.push(second-first);
                else if(str.equals("*"))
                    st.push(second*first);
                else if(str.equals("/"))
                    st.push(second/first);
            }else{
                st.push(Integer.parseInt(str));
            }
        }
        return st.pop();
    }
}

// Time Complexity - O(n)
// Space Complexity - O(n)
