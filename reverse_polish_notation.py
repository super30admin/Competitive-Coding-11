// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
a) if the value is digit we add it to the stack.
b)If it is a operator then we pop the two elements from the stack and perform the operation and then again add it to the stack.
c)we continue this process till we reach a single element.

# Time complexity --> o(n)
# space complexity --> o(n)
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack=[]
        for i in tokens:
            if i!='+' and i!='-' and i!='*' and i!='/':
                stack.append(i)
            else:
                val0=int(stack.pop())
                val1=int(stack.pop())
                if i=='+':
                    stack.append(val0+val1)
                elif i=='-':
                    stack.append(val1-val0)
                elif i=='*':
                    stack.append(val0*val1)
                else:
                    stack.append(int(val1/val0))
            # print(stack,i)
        return stack[0]
        
        