import java.util.*;

public class RPN {

    //As we need to wait for an operator to perform mathematical operation.
    //We can use stack to hold the numbers.
    //If it is a number put it in to the stack.
    //Else get the last two items and perform the operation
    
    //TC:O(N) Iterating the entire array only once.
    //SC:O(N) Using the Stack for Auxilary purposes.
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0)
            return 0;
        Stack<Integer> stack = new Stack();
        HashSet<String> set = new HashSet();
        set.add("*");
        set.add("+");
        set.add("-");
        set.add("/");

        for (String token : tokens) {
            if (set.contains(token)) {
                if (!stack.isEmpty()) {
                    int numberOne = stack.pop();
                    int numberTwo = stack.pop();
                    int currentResult = 0;
                    switch (token) {
                        case "*":
                            currentResult = numberTwo * numberOne;
                            break;
                        case "-":
                            currentResult = numberTwo - numberOne;
                            break;
                        case "/":
                            currentResult = numberTwo / numberOne;
                            break;
                        case "+":
                            currentResult = numberTwo + numberOne;
                            break;
                    }
                    stack.push(currentResult);
                }
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        RPN rpn = new RPN();
        int result = rpn.evalRPN(new String[] { "2", "1", "+", "3", "*" });
        System.out.println("The result is: " + result);
    }
}
