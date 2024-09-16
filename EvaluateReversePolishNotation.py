"""
Time Complexity : O(n) where n is the no. of elements in the token.
Space Complexity : O(n) where n is the no. of elements in the token.
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        # We traverse through the string and check whether it is a digit or a number.
        # If it is a digit we push it into the stack till we find the next operator.
        # When we find the operator we pop the top twice to perform operation on those
        # digits. At the end we return top stack element which is our evaluation
        for c in tokens:
            if c not in "+/-*":
                stack.append(int(c))
            else:
                dig2 = stack.pop()
                dig1 = stack.pop()
                if c == "*":
                    stack.append(dig1 * dig2)
                elif c == "/":
                    stack.append(int(dig1 / dig2))
                elif c == "+":
                    stack.append(dig1 + dig2)
                else:
                    stack.append(dig1 - dig2)
        return stack.pop()
                