# Time O(3n)
# Space O(n)
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        n = len(num)
        if n == k: return "0"
        stack = [num[0]]
        i = 1
        while i < n:
            if k == 0:
                break
            while len(stack) > 0 and stack[-1] > num[i] and k != 0:
                stack.pop()
                k -= 1 
            stack.append(num[i])
            i += 1
        result = num[i:]
        while len(stack) > 0:
            while k != 0:
                stack.pop()
                k -= 1
            result = stack.pop() + result
        m = len(result)
        i = 0
        while i < m:
            if result[i] == "0":
                i += 1
            else: break
        result = result[i:] if i < m else "0"
        return result