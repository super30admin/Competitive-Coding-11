import java.util.Stack;

public class RemoveKElements {

    // TC : O(n) n - length of num string
    // SC : O(k) we'll be putting only k elements in the stack.
    public String removeKdigits(String num, int k) {
        if(num == null || num.length() == 0 || num.length() == k) return "0";

        Stack<Character> stack = new Stack<>();

        for(int i=0; i < num.length(); i++) {

            // This will ensure that only k elements ar ein the stack
            while(k > 0 && !stack.isEmpty() && num.charAt(i) < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        // It may be possible that the value of k is still non-zero
        while(k > 0){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        // for num = "10" k = 1
        while(sb.length() > 1 && sb.charAt(sb.length() - 1) == '0')
            sb.deleteCharAt(sb.length() - 1);

        return sb.reverse().toString();
    }
}
