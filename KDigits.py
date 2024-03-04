# Time Complexity: O(N)
# Space Complexity: O(N)
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = collections.deque()
        for i in range(len(num)):
            while len(stack) > 0 and num[i] < stack[-1] and k > 0: 
                stack.pop()
                k -= 1
            stack.append(num[i])
        
        while k > 0:
            stack.pop()
            k -= 1

        while len(stack) > 0 and stack[0] == "0":
            stack.popleft()

        if len(stack) == 0:
            return "0" 

        return "".join(stack
