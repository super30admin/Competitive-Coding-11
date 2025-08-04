# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        
        operators = ['+','-','/','*']
        for token in tokens:
            # For Operands
            if token not in operators:
                stack.append(int(token))
                continue
            b = stack.pop()
            a = stack.pop()
            res = 0
            if token == '+':
                res = a+b
            elif token == '-':
                res = a-b
            elif token == '*':
                res = a*b
            elif token == '/':
                res = int(a/b)
            stack.append(res)
        return stack[-1]
            
            