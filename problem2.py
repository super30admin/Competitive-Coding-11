# Evaluate Reverse Polish Notation
# // Time Complexity : O(N)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack=[]
        for i in tokens:
            total=None
            if i=="+":                                      #if the current element is an operator, then pop the last two elements and apply the operator to the elements
                total=(stack.pop()+stack.pop())
            elif i=='-':
                second=stack.pop()
                total = stack.pop()-second
                
            elif i=='*':
                total=(stack.pop()*stack.pop())
            elif i=='/':
                second=stack.pop()
                total = int(stack.pop()/second)
                
            stack.append(int(i)) if total==None else stack.append(total)        #if current value is a number, add that, or else add the total value
        return stack[0]
                
        