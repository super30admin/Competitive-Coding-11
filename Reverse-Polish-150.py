# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def evalRPN(self, tokens):
        """
        :type tokens: List[str]
        :rtype: int
        """
        if len(tokens) == 0:
            return 0
        
        stack = []
        operators = ['+', '-', '*', '/']
        
        for t in tokens:
            if t not in operators:
                stack.append(t)
            else:
                n1 = int(stack.pop())
                n2 = int(stack.pop())
                
                print n1,n2, t
                if t == '+':
                    res = n2 + n1
                elif t == '-':
                    res = n2 - n1
                elif t == '*':
                    res = n2 * n1
                else:
                    res = int(float(n2)/ n1)
                stack.append(res)
        return stack.pop()
