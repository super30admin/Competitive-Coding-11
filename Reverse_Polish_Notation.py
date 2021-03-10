"""
Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : no
If we get a number, we just push it to the stack, when we get an operator, we pop top 2 values from stack, perform operation
and push resultant values to stack. Finally, the result would be value on top of the stack.
"""

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        if not tokens or len(tokens) == 0:
            return 0
        operators = {'+','-','/','*'}
        stack = []
        
        for t in tokens:
            if t in operators:
                second = stack.pop()
                first = stack.pop()
                if t == "+":
                    stack.append(first + second)
                elif t == "-":
                    stack.append(first - second)
                elif t == "*":
                    stack.append(first * second)
                else:
                    stack.append(int(first/ second))
            else:
                stack.append(int(t))
        return stack[-1]
