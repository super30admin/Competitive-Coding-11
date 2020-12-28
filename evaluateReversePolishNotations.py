#Time Complexity : O(n) where n is number of tokens
#Space Complexity : O(n) where n is number of tokens
#Did this code successfully run on Leetcode : Yes


class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for token in tokens:
            if token == "+":
                res = stack.pop() + stack.pop()
                stack.append(res)
            elif token == "-":
                op1, op2 = stack.pop(), stack.pop()
                res = op2 - op1
                stack.append(res)
            elif token == "*":
                res = stack.pop() * stack.pop()
                stack.append(res)
            elif token == "/":
                op1, op2 = stack.pop(), stack.pop()
                res = int(op2/op1)
                stack.append(res)
            else:
                stack.append(int(token))
        return stack[-1]
