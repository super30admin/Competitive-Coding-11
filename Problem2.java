import java.util.Stack;

public class Problem2 {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;

        int n = tokens.length;
        Stack<Integer> s = new Stack<>();

        for (String temp : tokens) {
            if (!"*/+-".contains(temp)) {
                s.push(Integer.valueOf(temp));
            } else {
                int i1 = s.pop();
                int i2 = s.pop();
                int result = 0;

                if (temp.contains("+")) {
                    result = i1 + i2;
                } else if (temp.contains("/")) {
                    result = i2 / i1;
                } else if (temp.contains("*")) {
                    result = i1 * i2;
                } else {
                    result = i2 - i1;
                }
                s.push(result);
            }
        }
        return s.pop();
    }

    public static void main(String[] args) {

        String[] abc = new String[]{"2", "1", "+", "3", "*"};
        Problem2 problem2 = new Problem2();
        System.out.println("final value " + problem2.evalRPN(abc));
    }
}
