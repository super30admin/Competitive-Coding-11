/**
 * Time Complexity:  O(n)  where n is the length of the tokens
 * Space Complexity: O(n) where n is the length of the tokens
 */
class Solution {
    Set<String> operators;

    public int evalRPN(String[] tokens) {
        operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        Stack<Integer> st = new Stack<>();
        int result = 0;

        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i];
            int num = 0;

            if (!operators.contains(str)) {
                num = Integer.parseInt(str);
                st.push(num);
            } else {
                int num1 = st.pop();
                int num2 = st.pop();
                switch (str) {
                    case "+":
                        result = num2 + num1;
                        break;
                    case "-":
                        result = num2 - num1;
                        break;
                    case "*":
                        result = num2 * num1;
                        break;
                    case "/":
                        result = num2 / num1;
                        break;

                }
                st.push(result);
            }
        }

        if (st.isEmpty()) {
            return result;
        } else {
            return st.pop();
        }

    }
}