#TC:O(n)
#SC:O(n)
class Solution:
    def evalRPN(self, tokens) :
        stack = []

        for i in tokens:
            if i not in "+-*/":
                stack.append(int(i))
                continue

            num1 = stack.pop()
            num2 = stack.pop()

            result = 0

            if i == "+":
                result = num1 + num2
            elif i == "-":
                result = num2 - num1

            elif i == "*":
                result = num1 * num2

            else:
                result = int(num2 / num1)

            stack.append(result)

        return stack.pop()