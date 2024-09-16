#TC:O(n)
#SC:O(n)
class Solution:
    def removeKdigits(self, num, k) :
        if num == None or len(num) == 0:
            return " "

        stack = []

        for i in num:
            while stack and k and stack[-1] > i:
                stack.pop()
                k -= 1
            stack.append(i)

        while k:
            stack.pop()
            k -= 1
        return "".join(stack).lstrip('0') or "0"