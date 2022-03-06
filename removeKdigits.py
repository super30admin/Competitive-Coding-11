#O(n) time and O(n) space solution
#n - number of elements in the input string
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        for n in num:
            while k > 0 and stack and stack[-1] > n:
                k -= 1
                stack.pop()
            stack.append(n)
        stack = stack[:len(stack) - k]
        result = "".join(stack)
        return str(int(result)) if result else "0"