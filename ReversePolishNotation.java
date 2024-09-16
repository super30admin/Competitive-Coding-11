// Time: O(N) | Space: O(N)

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("/");
        set.add("*");
        for (String token : tokens) {
            // whenever we encounter a symbol
            // we take the top 2 values in the stack, perform the computation with the symbol push it back,
            // else we push in the number onto stack
            if (set.contains(token)) {
                int secondValue = s.pop();
                int firstValue = s.pop();
                switch (token) {
                    case "+":
                        s.push(firstValue + secondValue);
                        break;
                    case "-":
                        s.push(firstValue - secondValue);
                        break;
                    case "/":
                        s.push(firstValue / secondValue);
                        break;
                    default:
                        s.push(firstValue * secondValue);
                }
            } else s.push(Integer.parseInt(token));

        }
        return s.peek();
    }
}