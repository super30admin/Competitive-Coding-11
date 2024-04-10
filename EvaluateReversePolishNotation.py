'''
TC: O(n) - Go through the input array
SC: O(n) - Stack space
'''
from typing import List

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for i, token in enumerate(tokens):
            if token == '+' or token == '-' or token == '*' or token == '/':
                a,b = stack.pop(), stack.pop()
                if token == '+':
                    stack.append(a+b)
                elif token == '-':
                    stack.append(b-a)
                elif token == '*':
                    stack.append(a*b)
                else:
                    sign = 1
                    if b<0 and a<0:
                        sign = 1
                    elif b<0 or a<0:
                        sign = -1
                    stack.append(sign*(abs(b)//abs(a)))
            else:
                stack.append(int(token))
        return stack[-1]
s = Solution()
print(s.evalRPN(["2","1","+","3","*"]))
print(s.evalRPN(["4","13","5","/","+"]))
print(s.evalRPN(["10","6","9","3","+","-11","*","/","*","17","+","5","+"]))