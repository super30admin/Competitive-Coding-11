# Time Complexity: O(n)
# Space Complexity: O(n)
# Ran on Leetcode: Yes

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        n = len(num)
        if n == k:
            return "0"
        stack = []
        for elem in num:
            while len(stack) and stack[-1] > elem and k > 0:
                stack.pop()
                k -= 1
            stack.append(elem)
        while k > 0:
            stack.pop()
            k -= 1
            
        if stack[0] == "0":
            i = 0
            while i < len(stack):
                if stack[i] != "0":
                    break
                i += 1
            
            if i == len(stack):
                return "0"    
            else:
                stack = stack[i:]
        
        return "".join(stack)
        