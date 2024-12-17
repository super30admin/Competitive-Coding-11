class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("/");
        set.add("*");
        int n = tokens.length;
        for(int i=0;i<n;i++){
            String curr = tokens[i];
            if(!set.contains(curr)){
                st.push(Integer.parseInt(curr));
            }
            else if(curr.equals("+")){
                int num2=st.pop();
                st.push(st.pop()+num2);
            }
            else if(curr.equals("-")){
                int num2=st.pop();
                st.push(st.pop()-num2);
            }
            else if(curr.equals("*")){
                int num2=st.pop();
                st.push(st.pop()*num2);
            }
            else if(curr.equals("/")){
                int num2=st.pop();
                st.push(st.pop()/num2);
            }
        }
        return st.pop();
    }
}
