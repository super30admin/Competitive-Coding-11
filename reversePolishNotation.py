# Approach: Stack
# TC: O(n)
# SC: O(n) although its unlikely that all n elements will be pushed to the stack ever, its still linear SC.
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for t in tokens:
            if t == "+":
                stack.append(stack.pop() + stack.pop())
            elif t == "-":
                stack.append(- stack.pop() + stack.pop())
            elif t == "*":
                stack.append(stack.pop() * stack.pop())
            elif t == "/":
                x = stack.pop() 
                stack.append(int(stack.pop() / x))
            else:
                stack.append(int(t))
        return stack.pop()
            