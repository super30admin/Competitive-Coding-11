# Time Complexity : O(NK)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Stack. Iterate over the list and check if the stack is not empty and k > 0 and element in stack is greater than the current number
# If it is greater then pop the element from the stack until k becomes 0 or it is the end of the string
# Append the elements to stack
# If k > 0 then pop the elements from the stack
# Join the stack and remove any 0's starting from the left and add it to res
# If the stack is empty return '0' else res


class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        if not num:
            return None
        stack = []
        for i in range(len(num)):
            while stack and stack[-1] > num[i] and k > 0:
                stack.pop()
                k -= 1
            stack.append(num[i])

        while k:
            stack.pop()
            k -= 1

        res = ''.join(stack).lstrip('0')

        if not res:
            return '0'
        return res