"""
Approach 1: using stack
1. push digits in stack
2. if you encounter a sign, resolve the top 2 digits and push the result in stack
3. stack will finally be left with the final result

TC: O(n)
SC: O(n)
"""
from collections import deque
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = deque()
        for char in tokens:
            if char not in '+-*/':
                stack.append(int(char))
                
            else:
                num2 = stack.pop()
                num1 = stack.pop()
                if char == '+':
                    stack.append(num1 + num2)

                if char == '-':
                    stack.append(num1 - num2)

                if char == '*':
                    stack.append(num1 * num2)

                if char == '/':
                    stack.append(int(num1 / num2)) # using this as int division uses floor operation
        return stack.pop()