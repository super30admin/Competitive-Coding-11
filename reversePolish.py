#Time Complexity: O(N)
#Space Complexity: O(N)
#Run on Leetcode: Yes
#Any Issues: No

def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        operators = {
            '+': operator.add, 
            '-': operator.sub,
            '*': operator.mul,
            '/': operator.truediv
        }
        while tokens:
            value = tokens.pop(0)
            if value in operators:
                num2, num1 = stack.pop(), stack.pop()
                stack.append(int(operators[value](num1, num2)))
            else:
                stack.append(int(value))
        return stack[-1]