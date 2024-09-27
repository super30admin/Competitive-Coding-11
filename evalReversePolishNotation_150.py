
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Approach:
# We want to search for the most recent values, hence we can use stack
# Push digits to stack and when the operator is encountered pop two digits and make an expression using the operator & two digits that were popped from stack. Push the expression on the stack, repeat the steps again.

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        operators = ['+', '-', '*','/']
        
        for s in tokens:
            if s in operators:
                first = int(stack.pop())
                second = int(stack.pop())
                
                if s == '+':
                    stack.append(second+first)
                    
                if s == '-':
                    stack.append(second-first)
                
                if s == '*':
                    stack.append(second*first)
                if s == '/':
                    stack.append(int(float(second)/first))
                    
            else:
                stack.append(s)
                
        return stack.pop()
            
        
        