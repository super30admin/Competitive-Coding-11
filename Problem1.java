import java.util.Stack;
/*
Remove K Digits
approach: use monotonic stack approach for increasing sequence
time: O(2n)
space: O(n)
 */
public class Problem1 {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();

        for (int i=0;i<num.length();i++) {
            int c = num.charAt(i)-'0';

            while (!st.isEmpty() && c<st.peek() && k-->0) {
                st.pop();
            }
            st.push(c);
        }

        while (k-->0) {
            st.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.insert(0, st.pop());
        }

        while(sb.length()>0 && sb.charAt(0)=='0') {
            sb.deleteCharAt(0);
        }

        return sb.length()>0?sb.toString():"0";
    }
}
