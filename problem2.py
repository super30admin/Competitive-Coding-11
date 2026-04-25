# problem 2 

# https://leetcode.com/problems/remove-k-digits/description/


class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        n = len(num)
        my_stack = []
        for i in range(n):
            while my_stack and k > 0 and my_stack[-1] > num[i]:
                my_stack.pop()
                k=k-1
            my_stack.append(num[i])
        while k > 0:
            k = k-1
            my_stack.pop()
        final_str = "".join(my_stack).lstrip('0')
        return final_str if final_str else "0"
        