# Time Complexity - O(n)
# Space Complexity - O(number of digits) for the stack

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []  # initializing an empty stack

        for c in tokens:
            if c in "/+*-":  # checking if the top element is an operator
                b, a = stack.pop(), stack.pop()

                if c == '+':
                    stack.append(a + b)
                elif c == '-':
                    stack.append(a - b)
                elif c == '*':
                    stack.append(a * b)
                else:
                    stack.append(int(float(a) / b))
            else:  # if not an operator simply append to the stack
                stack.append(int(c))

        return stack.pop()
