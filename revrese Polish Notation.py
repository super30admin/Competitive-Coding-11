#Time Complexity: O(N)
#Space Complexity: O(N)
class Solution(object):
    def evalRPN(self, tokens):
        """
        :type tokens: List[str]
        :rtype: int
        """
        stack = []
        
        for x in tokens:
            if stack == []:
                stack.append(int(x))
            elif x not in '+-/*':
                stack.append(int(x))
            else:
                l = len(stack) - 2
                if x == '+':
                    stack[l] = stack[l] + stack.pop()
                elif x == '-':
                    stack[l] = stack[l] - stack.pop()
                elif x == '*':
                    stack[l] = stack[l] * stack.pop()
                else:
                    stack[l] = int(float(stack[l]) / float(stack.pop()))      
        return stack[0]
        
            