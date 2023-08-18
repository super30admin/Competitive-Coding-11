//Time Complexity : O(N)
//Space Complexity : O(N)
class Solution {
    public String removeKdigits(String num, int k) {
        if (num == null || num.equals(""))
            return num;
        Stack<Character> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && (int) (stack.peek()) > (int) c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        for (int i = 0; i < k; i++)
            stack.pop();
        StringBuilder sb = new StringBuilder();
        boolean lead = true;
        for (char c : stack) {
            if (c == '0' && lead)
                continue;
            lead = false;
            sb.append(c);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}