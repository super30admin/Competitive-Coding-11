"""
# Time complexity - O(n) 
# Space Complexity: O(n)
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None
Approach : Traverse the list keep pushing digits to stack, and pop when operator occurs, compute and push processed result.
"""
class Solution:
    def evalRPN(self, tokens):
    
        stack = []

        for token in tokens:

            if token not in "+-/*":
                stack.append(int(token))
                continue

            num_2 = stack.pop()
            num_1 = stack.pop()

            res = 0
            if token == "+":
                res = num_1 + num_2
            elif token == "-":
                res = num_1 - num_2
            elif token == "*":
                res = num_1 * num_2
            else:
                res = int(num_1 / num_2)

            stack.append(res)

        return stack.pop()