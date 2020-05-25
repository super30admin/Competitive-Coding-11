import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
//Time Complexity: O(n)
//Space Complexity: O(n)

public class ReversePolishNotation {
	public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;
        Stack<Integer> st = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("/");
        set.add("*");
        for(String s: tokens){
            if(set.contains(s)){
                int first = st.pop();
                int second = st.pop();
                switch(s){
                    case "+":
                        st.push(second + first);
                        break;
                    case "-":
                        st.push(second - first);
                        break;
                    case "*":
                        st.push(second * first);
                        break;
                    case "/":
                        st.push(second / first);
                        break;
                }
            } else {
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}
