class Solution {
    public int evalRPN(String[] tokens) {
        final Deque<Integer> stack = new LinkedList<>();
        for (final String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "/":
                    int x = stack.pop();
                    stack.push(stack.pop() / x);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
}