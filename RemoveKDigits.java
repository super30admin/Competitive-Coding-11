public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();

        for (char c : num.toCharArray()) {
            while (k > 0 && !sb.isEmpty() && sb.charAt(sb.length() - 1) > c) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(c);
        }

        while (k > 0 && !sb.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }

        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            sb.deleteCharAt(i);
        }

        if (sb.isEmpty()) return "0";

        return sb.toString();
    }
}

//TC: O(n), SC: O(n)
