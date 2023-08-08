# Time Complexity : O(n)
# Space Complexity : O(n)
# Code ran on LeetCode
# Maintain a stack to process the most recent numbers first. Use int(b/a) for division since the division truncates towards zero. Compute the expression and add the computed value to the stack.

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        
        n = len(tokens)

        stack = []
        exp= ['+', '-', '*', '/']

        for i in range(n):
            cur = tokens[i]

            if cur not in exp:
                stack.append(int(cur))

            else:
                if len(stack) >= 2:
                    a = int(stack.pop())
                    b = int(stack.pop())

                    if cur == '+':
                        stack.append(a+b)
                    elif cur == '-':
                        stack.append(b - a)
                    elif cur == '*':
                        stack.append(a*b)
                    elif cur == '/':
                        stack.append(int(b/a))
        return stack[0]