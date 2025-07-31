"""
Use a stack to store operands
When we see an operator, pop two operands, apply the operation, and push the result
At the end, the stack will contain the final result
"""
"""
Time Complexity: O(n) - Each token is processed once
Space Complexity: O(n) - Stack size in worst case
"""


class reversePolish:
    def evalRPN(self, tokens: list[str]) -> int:
        stack = []

        for token in tokens:
            if token not in "+-*/":
                stack.append(int(token))
            else:
                b = stack.pop()
                a = stack.pop()
                if token == "+":
                    stack.append(a + b)
                elif token == "-":
                    stack.append(a - b)
                elif token == "*":
                    stack.append(a * b)
                else: 
                    stack.append(int(a / b))
        return stack[0]

if __name__ == "__main__":
    obj = reversePolish()
    print(obj.evalRPN(["2", "1", "+", "3", "*"]))          
    print(obj.evalRPN(["4", "13", "5", "/", "+"]))   
    print(obj.evalRPN(["10", "6", "9", "3", "/", "-", "*"]))
