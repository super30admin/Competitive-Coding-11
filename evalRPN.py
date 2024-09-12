#Leetcode : Pass
#TC - O(n), Sc-O(n)
# 1)If num then push instack
# 2)If operator pop 2nums from stack and perform num2 (operator) num1 and push result into stack
# 3)end of array then return the popped elem from stack

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack =[]
        sym = ['+','-','*','/']
        for i in tokens:
            #1
            if i not in sym:
                stack.append(int(i))
            #2
            else:
                num2 = stack.pop()
                num1 = stack.pop()
                if i =='+':
                    stack.append((num1+num2))
                elif i =='-':
                    stack.append((num1-num2))
                elif i =='*':
                    stack.append((num1*num2))
                else:
                    stack.append(int(num1/num2))
        #3
        return stack.pop()
