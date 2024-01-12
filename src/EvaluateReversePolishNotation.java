// Time complexity:  O(n)
// Space Complexity: O(n)

class Solution {

    public int evalRPN(String[] tokens) {

        Set<String> operators = new HashSet<>() {{
            add("+");
            add("-");
            add("*");
            add("/");
        }};
        Stack<Integer> stack = new Stack<>();
        
        for(String token : tokens) {
            if(operators.contains(token)) {
                int secondOperand = stack.pop();
                int firstOperand = stack.pop();
                int val = 0;
                switch(token) {
                    case "+": val = firstOperand+secondOperand; break;
                    case "-": val = firstOperand-secondOperand; break;
                    case "*": val = firstOperand*secondOperand; break;
                    case "/": val = firstOperand/secondOperand; break;
                }
                stack.push(val);
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();

    }

}
