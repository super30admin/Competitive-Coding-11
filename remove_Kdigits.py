# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []

        for c in num:
            while stack and k > 0 and stack[-1] > c:
                stack.pop()
                k-=1
            stack.append(c)
        while k:
            stack.pop()
            k-=1

        i = 0
        while i < len(stack) and stack[i] == "0":
            i+=1

        if len(stack[i:]) > 0:
            result = ''.join(stack[i:])
        else:
            result = "0"
        
        return result



        