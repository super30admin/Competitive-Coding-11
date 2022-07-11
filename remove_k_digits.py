# Time Complexity : O(N) where N is length of number string
# Space Complexity : O(N) where N is length of number string
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        i = 0
        stack = []
        while i < len(num):
            if i != 0:
                while len(stack) > 0 and int(stack[-1]) > int(num[i]) and k > 0:
                    stack.pop()
                    k -= 1
            
            stack.append(num[i])
            i += 1
            
        result = 0
        for i in range(len(stack) - k):
            result = result * 10 + int(stack[i])
        
        return str(result)