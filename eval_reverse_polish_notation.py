class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []

        for tok in tokens:
            if len(tok) > 1 or tok.isdigit():
                stack.append(int(tok))
            else:
                if tok == "+":
                    stack[-2] += stack[-1]
                elif tok == "-":
                    stack[-2] -= stack[-1]
                elif tok == "*":
                    stack[-2] *= stack[-1]
                else:
                    stack[-2] = int(float(stack[-2]) / stack[-1])
                stack.pop()
        return stack[0]

    # time complexity is O(n)
    # space complexity is O(n)
