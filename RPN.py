# Approach:
# Use a stack to evaluate the Reverse Polish Notation (RPN). Push operands onto the stack.
# When encountering an operator, pop the last two operands from the stack, perform the operation, and push the result back onto the stack. At the end, the stack will contain the final result.
# Time Complexity: O(n), where n is the length of the tokens array.
# Space Complexity: O(n) for the stack.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: None

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []  # Stack to store operands

        # Iterate over each token in the input array
        for token in tokens:
            if token in {"+", "-", "*", "/"}:  # Check if the token is an operator
                # Pop the top two operands from the stack
                b = stack.pop()
                a = stack.pop()

                # Perform the operation and push the result back to the stack
                if token == "+":
                    stack.append(a + b)
                elif token == "-":
                    stack.append(a - b)
                elif token == "*":
                    stack.append(a * b)
                elif token == "/":
                    # Perform integer division truncating toward zero
                    stack.append(int(a / b))
            else:
                # If the token is a number, convert it to integer and push onto the stack
                stack.append(int(token))

        # The result of the evaluation will be the only element left in the stack
        return stack[0]
