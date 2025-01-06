class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        # Initialize an empty stack to store intermediate results
        stack = []
        
        # Loop through each token in the input
        for c in tokens:
            # If the token is an operator, perform the operation
            if c == "+":
                stack.append(stack.pop() + stack.pop())  # Pop top two numbers, add them, and push the result
            elif c == "-":
                a, b = stack.pop(), stack.pop()  # Pop top two numbers
                stack.append(b - a)  # Subtract (order matters)
            elif c == "*":
                stack.append(stack.pop() * stack.pop())  # Pop top two numbers, multiply them, and push the result
            elif c == "/":
                a, b = stack.pop(), stack.pop()  # Pop top two numbers
                stack.append(int(b / a))  # Divide (order matters), truncate toward zero
            else:
                # If the token is a number, push it onto the stack
                stack.append(int(c))
        
        # The result of the expression is the last item in the stack
        return stack[0]

