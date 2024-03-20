import java.util.Stack;

public class RemoveKDigits {
    // TC: O(N) where N is length of num
    // SC: O(N) where N is length of num
    public String removeKdigits(String num, int k) {
        Stack<Character> incStack = new Stack<>();
        for (char ch : num.toCharArray()) {
            while (!incStack.isEmpty() && k > 0 && incStack.peek() > ch) {
                incStack.pop();
                k--;
            }
            incStack.push(ch);
        }

        for (int i = 0; i < k; i++) {
            incStack.pop();
        }
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for (char ch : incStack) {
            if (leadingZero && ch == '0') {
                continue;
            }
            leadingZero = false;
            sb.append(ch);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
