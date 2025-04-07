# Time O(n)
# Space O(n)
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        n = len(tokens)
        stack = []
        for s in tokens:
            if s.isdigit() or (s[0]== "-" and len(s) > 1):
                stack.append(int(s))
            else:
                b = stack.pop()
                a = stack.pop()
                if s == "+":
                    stack.append(a + b)
                elif s == "-":
                    stack.append(a - b)
                elif s == "*":
                    stack.append(a * b)
                elif s == "/":
                    stack.append(int(a / b))
        return stack[-1]

