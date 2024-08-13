
class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }
        int len = num.length();
        Stack<Character> s = new Stack<>();
        int i = 0;
        while (i < len) {
            while (k > 0 && !s.isEmpty() && s.peek() > num.charAt(i)) {
                s.pop();
                k--;
            }
            s.push(num.charAt(i));
            i++;
        }
        while (k > 0) {
            s.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}