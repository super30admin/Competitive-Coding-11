#Time Complexity: O(N)
#Space Complexity: O(N)
#Run on Leetcode: Yes
#Any Issues: No

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        N = len(num)
        p = N - k
        stack = []
        for i in range(N):
            while stack and stack[-1] > num[i] and len(stack) + N - i > p:
                stack.pop()
            if len(stack) < p:
                stack.append(num[i])

        i = 0
        while stack and i < len(stack) and stack[i] == '0':
            i += 1
        
        s = "".join(stack[i:])
        return s if s else '0'