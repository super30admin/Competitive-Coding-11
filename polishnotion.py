# Time Complexity : O(N) as we are iterating through the tokens list once
# Space Complexity : O(N) as we are using extra space to store the stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes

# Your code here along with comments explaining your approach:
# I am using a stack to evaluate the Reverse Polish Notation.
# I will iterate through each token in the input list.
# If the token is an operator (+, -, *, /), I will pop the top two elements from the stack, perform the operation, and push the result back onto the stack.
# If the token is a number, I will convert it to an integer and push it onto the stack.
# At the end of the iteration, the stack will contain one element which is the result of the evaluation.    

from typing import List
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for i in range(len(tokens)):
            curr = tokens[i]
            if curr == "+":
                first = stack.pop()
                second = stack.pop()
                stack.append(first+second)
            elif curr == "-":
                first = stack.pop()
                second = stack.pop()
                stack.append(second-first)
            elif curr == "*":
                first = stack.pop()
                second = stack.pop()
                stack.append(second*first)
            elif curr == "/":
                first = stack.pop()
                second = stack.pop()
                stack.append(int(second/first))   
            else:
                stack.append(int(curr)) 
        return stack[-1]