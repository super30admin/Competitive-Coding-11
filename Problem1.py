#Time Complexity : O(N)
#Space Complexity : O(N)
import math
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for i in tokens:
            if i != '-' and i != '+' and i!= '*' and i!= '/':
                stack.append(i)
            else:
                temp1 = int(stack.pop())
                temp2 = int(stack.pop())
                if i == '+':
                    stack.append(temp2 + temp1)
                if i == '-':
                    stack.append(temp2 - temp1)
                if i == '*':
                    stack.append(temp2 * temp1)
                if i == '/':
                    temp3 = (temp2/temp1)
                    stack.append((temp3))
                    
        return int(stack.pop())
                