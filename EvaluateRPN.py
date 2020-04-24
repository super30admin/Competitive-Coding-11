'''
Solution:
1.  Maintain a HashSet for operators and if any operation occurred, pop 2 elements and push 
    the operation onto the stack.
2.  If a number occurred, just push the element to the stack.
3.  Return the remaining element in the stack.

Time Complexity:    O(N)    |   Space Complexity:   O(N)
--- Passed all testcases successfully on leetcode.
'''


class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        
        #   initializations
        operators = set(['+', '-', '*', '/'])
        stack = []
        
        #   for each token
        for token in tokens:
            
            #   if its an operator => pop 2 elements and push the resultant operation
            if (token in operators):
                
                num2 = stack.pop()
                num1 = stack.pop()
                
                if (token == '+'):
                    stack.append(num1 + num2)
                elif (token == '-'):
                    stack.append(num1 - num2)
                elif (token == '*'):
                    stack.append(num1 * num2)
                elif (token == '/'):
                    stack.append( int(num1 / num2) )
            
            #   else just push    
            else:
                stack.append(int(token))
        
        #   return the remaining element in the stack        
        return stack.pop()