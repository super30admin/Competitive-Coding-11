#https://leetcode.com/problems/remove-k-digits/description/
# Time Complexity: O(n), where n is the number of tokens. We go through each token exactly once and every stack operation (push or pop) is O(1).
# Space Complexity: O(n),In the worst case (many numbers before operators), the stack can hold up to about n/2 numbers.
# Approach:
# We go through each token one by one using a stack.
# If the token is a number, we push it onto the stack.
# If the token is an operator, we pop the top two numbers from the stack.
# The first number popped is the second operand (num2), since it was pushed most recently.
# The second number popped is the first operand (num1).
# We apply the operator on num1 and num2 (in that order, since order matters for * and /), then push the result back onto the stack.
# After processing all tokens, only one number remains in the stack, that is the final answer.

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []  # stack to hold numbers as we process tokens

        for i in range(len(tokens)):
            token = tokens[i]  # current token, either a number or an operator

            if token == "+":
                num2 = stack.pop()  # most recently pushed number, second operand
                num1 = stack.pop()  # first operand
                stack.append(num1 + num2)  # push the sum back
            
            elif token == "-":
                num2 = stack.pop()  
                num1 = stack.pop()  
                stack.append(num1 - num2)  # order matters, so first operand minus second
            
            elif token == "/":
                num2 = stack.pop()  
                num1 = stack.pop()  
                stack.append(int(num1 / num2))  # int() truncates toward zero
            
            elif token == "*":
                num2 = stack.pop()  
                num1 = stack.pop()  
                stack.append(num1 * num2)  # push the product back
            
            else:
                stack.append(int(token))  # it's a number, convert from string and push
        
        return stack.pop()  # only one number left, that is the result


        