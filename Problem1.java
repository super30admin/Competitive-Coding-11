import java.util.Stack;

public class Problem1 {
    // TC : O(n)
    // SC : O(n)
    public String removeKdigits(String num, int k) {

        if (num == null || k == 0) return num;

        int n = num.length();
        Stack<Character> s = new Stack<>();
        int lvl = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);

            while (!s.isEmpty() && c < s.peek() && lvl < k) {
                s.pop();
                lvl++;
            }
            s.push(c);
        }

        while (lvl < k) {
            s.pop();
            lvl++;
        }

        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        sb.reverse();

        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }
}
