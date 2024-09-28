#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        n = len(tokens)
        op = {'+':1,'-':1,'*':1,'/':1}
        stack = list()
        for i in range(n):
            if tokens[i] not in op:
                stack.append(int(tokens[i]))
                
            else:
                ch = tokens[i]
                val = stack.pop()
                if ch == '+':
                    stack[-1] = stack[-1] + val
                    
                elif ch == '-':

                    stack[-1] = stack[-1] - val
                    
                elif ch == '*':
                    stack[-1] = stack[-1] * val
                    
                elif ch == '/':
                    if stack[-1]*val < 0:
                        stack[-1] = -1*(abs(stack[-1])//abs(val))
                    else:
                        stack[-1] = stack[-1] // val
                    
        return stack[-1]
                    
                