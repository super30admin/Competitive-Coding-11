# Time complexity : O(n)
# Space complexity : O(n)

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        # empty stack
        stack = []
        
        n = len(tokens)
        res = 0
        
        # traversing over all the strings in the token list
        for i in range(n):
            ch = tokens[i]
            
            # if string is any operator
            if ch == '+' or ch == '-' or ch == '*' or ch == '/':
                # pop two numbers from the stack
                num1 = stack.pop()
                num2 = stack.pop()
                
                # apply the relevant operator, find the res and append it to the stack
                if ch == '+':
                    res = num1 + num2
                elif ch == '-':
                    res = num2 - num1
                elif ch == '*':
                    res = num1 * num2
                else:
                    res = int(num2/num1)
                stack.append(res)
            
            else:
                # if the string is a number, convert the string to int
                stack.append(int(ch))
        
        # return the final res as the top of stack
        return stack[0]
