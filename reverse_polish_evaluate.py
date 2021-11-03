# // Time Complexity : O(n) where n is the length of the nums array 
# // Space Complexity : O(n)  
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach 
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        
        for i in range(len(tokens)):
            evaluate = 0
            if tokens[i] not in ['+','-','*','/']:
                num = int(tokens[i])
                stack.append(num)
            else:
                second = stack.pop()
                first = stack.pop()
                if tokens[i] == '+':
                    evaluate = first + second
                elif tokens[i] == '-':
                    evaluate = first - second
                elif tokens[i] == '*':
                    evaluate = first * second
                elif tokens[i] == '/':
                    evaluate = math.floor(first / second) if (first / second) > 0 else math.ceil(first / second)                             
                stack.append(evaluate)
        
        return stack[-1]
                        
        