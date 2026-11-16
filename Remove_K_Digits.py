# Time Complexity : O(NK)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Stack. Iterate over the list and check if the stack is not empty and k > 0 and element in stack is greater than the current number
# If it is greater then pop the element from the stack until k becomes 0 or it is the end of the string or the top number is less than the current number
# Append the elements to stack
# If the k doesnt become 0 so we pop the elements from the stack until it becomes 0
# Return join the stack and remove any 0's starting from the left using lstrip("0") or "0" if the stack is empty


class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        res = ""
        for i in range(len(num)):
            while stack and stack[-1] > num[i] and k > 0:
                k -= 1
                stack.pop()
            stack.append(num[i])
        while k > 0:
            stack.pop()
            k -= 1
        return ''.join(stack).lstrip("0") or "0"