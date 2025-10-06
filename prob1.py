# Evaluate Reverse Polish Notation
# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        token_stack = []
        for token in tokens:
            # If the token is a number, push it onto the stack
            if token not in ["+","-","*","/"]:
                token_stack.append(int(token))
                continue
            # If the token is an operator, pop the top two numbers from the stack, apply the operator, and push the result back onto the stack
            num1, num2 = token_stack.pop(), token_stack.pop()
            if token == "+":
                token_stack.append(num1+num2)
            if token == "-":
                token_stack.append(num2-num1)
            if token == "*":
                token_stack.append(num1*num2)
            if token == "/":
                token_stack.append(int(num2/num1))
        return token_stack.pop() # The final result is the only number left in the stack
