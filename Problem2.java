class Solution {
    public int evalRPN(String[] t) {
        Stack<Integer> st = new Stack<>();
        int n = t.length, res = Integer.parseInt(t[0]);
        for (int i = 0; i < n; i++) {
            if (num(t[i]))
                st.push(Integer.parseInt(t[i]));
            else {
                char x = t[i].charAt(0);
                int a = st.pop();
                int b = st.pop();
                switch (x) {
                    case '+':
                        res = b + a;
                        break;
                    case '-':
                        res = b - a;
                        break;
                    case '*':
                        res = b * a;
                        break;
                    case '/':
                        res = b / a;
                        break;
                }
                st.push(res);
            }
        }
        return res;
    }

    public boolean num(String s) {
        try {
            int d = Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}