# Time Complexity : O(n) 
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Solution:
    def evalRPN(self, tokens):
        if len(tokens) == 0:
            return 0 
        stack = []
        operators = ('+','-','/','*')        
        for i in range(len(tokens)):
            if tokens[i] not in operators:
                stack.append(tokens[i])
            else:
                num1 = int(stack.pop())
                num2 = int(stack.pop())
                res = 0 
                if tokens[i] == '+':
                    res = num2 + num1
                elif tokens[i] == '-':
                    res = num2 - num1 
                elif tokens[i] == '*':
                    res = num2 * num1 
                else:
                    res = int(float(num2) / num1)
                stack.append(res)
        return stack.pop()

if __name__ == "__main__":
    s = Solution()
    print(s.evalRPN(["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]))