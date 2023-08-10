# Time Complexity : O(n)
# Space Complexity :O(n)
# Passed on Leetcode: yes


class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        
        for token in tokens:
            if token.isdigit() or (token[0] == '-' and token[1:].isdigit()):
                stack.append(int(token))  # Push operands onto the stack
            else:
                # Pop two operands and perform the operation based on the operator
                operand2 = stack.pop()
                operand1 = stack.pop()
                if token == "+":
                    stack.append(operand1 + operand2)
                elif token == "-":
                    stack.append(operand1 - operand2)
                elif token == "*":
                    stack.append(operand1 * operand2)
                elif token == "/":
                    # Handle division with truncation toward zero
                    stack.append(int(operand1 / operand2))
        
        # The final result will be the only element left in the stack
        return stack[0]