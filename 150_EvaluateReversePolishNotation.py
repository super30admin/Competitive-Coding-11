"""
TC: O(N)
SC:O(N)
Logic:
Use stack. Push operands to stack. If operator, pop top 2 operands, operate and push back
Return stack[0]
"""
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for t in tokens:
            if t not in ['+','-','*','/']:
                stack.append(int(t))
            elif t == '+':
                op1 = stack.pop()
                op2 = stack.pop()
                stack.append(op1+op2)
            elif t == '-':
                op1 = stack.pop()
                op2 = stack.pop()
                stack.append(op2-op1)
            elif t == '*':
                op1 = stack.pop()
                op2 = stack.pop()
                stack.append(op1*op2)
            elif t == '/':
                op1 = stack.pop()
                op2 = stack.pop()
                stack.append(int(op2/op1))
        return stack[0]
