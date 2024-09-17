'''
Iterative:
Time Complexity: O(n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation:
If the token is not an operator then push the token into stack, if you see an operator pop the top of 2 elements of the
stack and perform the operation and push the result into the stack.

stack[0] will give the final answer.
'''
class Solution:
    def evaluate(self, operator, number1, number2):
        if operator == '*':
            return number1 * number2

        if operator == '+':
            return number1 + number2

        if operator == '-':
            return number1 - number2

        if operator == '/':
            return int(number1 / number2)

    def evalRPN(self, tokens: List[str]) -> int:
        if tokens == None:
            return 0

        if len(tokens) == 1:
            return tokens[0]

        stack = []
        operators = ('*', '/', '-', '+')
        for token in tokens:
            if token not in operators:
                stack.append(token)
            else:
                number2 = stack.pop()
                number1 = stack.pop()
                ans = self.evaluate(token, int(number1), int(number2))
                stack.append(ans)

        return stack[0]