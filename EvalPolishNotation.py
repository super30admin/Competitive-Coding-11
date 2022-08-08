#150. Evaluate Reverse Polish Notation
"""
Time Complexity : O(n)
Space COmpelxit y: O(n)
"""
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for ch in tokens:
            if ch == '+':
                a = stack.pop()
                b = stack.pop()
                ans = b + a
                stack.append(ans)
                
            elif ch == '-':
                a = stack.pop()
                b = stack.pop()
                ans = b - a
                stack.append(ans)
                
            elif ch == '*':
                a = stack.pop()
                b = stack.pop()
                ans = b * a
                stack.append(ans)
                
            elif ch == '/':
                a = stack.pop()
                b = stack.pop()
                ans = int(b / a)
                stack.append(ans)
                
            else:
                stack.append( int(ch) )
                
        return stack[-1]
