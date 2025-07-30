class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = collections.deque()
        
        for n in tokens:
            if n == "+":
                n2 = stack.pop()
                n1 = stack.pop()
                stack.append(n1 + n2)
            elif n == "-":
                n2 = stack.pop()
                n1 = stack.pop()
                stack.append(n1 - n2)
            elif n == "*":
                n2 = stack.pop()
                n1 = stack.pop()
                stack.append(n1 * n2)
            elif n == "/":
                n2 = stack.pop()
                n1 = stack.pop()
                stack.append(int(n1/n2))
            else:
                stack.append(int(n))
        return stack.pop()