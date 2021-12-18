# Time Complexity: O(n), where n - length of the input array
# Space Complexity: O(n), stack

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        if not tokens or len(tokens) == 0:
            return 0

        stack = []

        # Store the operators in a set
        operators = set()
        operators.add('+')
        operators.add('-')
        operators.add('*')
        operators.add('/')

        for s in tokens:

            # If the string is an operator, perform the operation on the last two items from stack,
            # and push the result into the stack
            if s in operators:
                operand1 = stack.pop()
                operand2 = stack.pop()

                if s == '+':
                    stack.append(operand2 + operand1)

                elif s == '-':
                    stack.append(operand2 - operand1)

                elif s == '*':
                    stack.append(operand2 * operand1)

                elif s == '/':
                    stack.append(int(operand2 / operand1))

            # Else if the string is a number, simply push it into the stack
            else:
                stack.append(int(s))

        return stack.pop()





