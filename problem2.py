#Time Complexity : O(n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : No


class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        if len(num) <= k:
            return "0"

        for c in num:
            while k > 0 and stack and stack[-1] > c:
                k -= 1
                stack.pop()
            stack.append(c)

        while stack and stack[0] == '0':
            stack.pop(0)

        while k > 0 and stack:
            stack.pop()
            k -= 1
        
        result = ''.join(stack)

        if not result:
            return "0"
        
        return result
