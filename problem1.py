# problem 1

# https://leetcode.com/problems/evaluate-reverse-polish-notation/

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for token in tokens:
            if token not in ['+','-','*','/']:
                stack.append(token)
            elif token == '+':
                val1 = int(stack.pop())
                val2 = int(stack.pop())
                stack.append(val1+val2)
            elif token == '-':
                # 4 - 3 
                val1 = int(stack.pop())
                val2 = int(stack.pop())
                stack.append(val2-val1) 
            elif token == '*':
                val1 = int(stack.pop())
                val2 = int(stack.pop())
                stack.append(val1*val2) 
            elif token == '/':
                val1 = int(stack.pop())
                val2 = int(stack.pop())
                stack.append(int(val2/val1))
        return int(stack[0])