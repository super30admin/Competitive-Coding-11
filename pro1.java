class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int a;
        int b;
        for (String s : tokens) {
            if (s.equals("+")) {
                b = stack.pop();
                a = stack.pop();
                stack.push(a + b);
            } else if (s.equals("-")) {
                b = stack.pop();
                a = stack.pop();
                stack.push(a - b);
            } else if (s.equals("*")) {
                b = stack.pop();
                a = stack.pop();
                stack.push(a * b);
            } else if (s.equals("/")) {
                b = stack.pop();
                a = stack.pop();
                stack.push((int) a / b);
            } else {
                stack.add(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
// Time:O(N)
// Space:O(N)