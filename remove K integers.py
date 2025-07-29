## Greedy monotonic stack
# Time Complexity : O(N)
# Space Complexity: O(N)
class Solution(object):
    def removeKdigits(self, num, k):
        """
        :type num: str
        :type k: int
        :rtype: str
        """
        if k >= len(num):
            return "0"

        stack = []
        nums = num

        for num in nums:
            while stack and num < stack[-1] and k > 0:
                stack.pop()
                k -= 1
            stack.append(num)

        stack_final = stack[:-k] if k else stack

        res = ''.join(stack_final).lstrip('0')

        return res if res else "0"
        
            







        