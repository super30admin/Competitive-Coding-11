# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
#
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        if len(num) == k:
            return '0'
        stack = []
        for i in num:
            while k > 0 and stack and int(i) < int(stack[-1]):
                stack.pop()
                k -= 1
            stack.append(i)
        while k > 0:
            stack.pop()
            k -= 1
        return str(int(''.join(stack)))


print(Solution().removeKdigits("1432219", 3))

# T.C - exponential
# class Solution:
#     def helper(self, num, k, path, index):
#         # base
#         if len(path) == len(num)-k:
#             self.min = min(self.min, int(''.join(path)))
#             return
#         # logic
#         for i in range(index, len(num)):
#             if self.check[i]:
#                 continue
#             path.append(num[i])
#             self.check[i] = True
#             self.helper(num, k, path, i)
#             self.check[i] = False
#             path.pop()

#     def removeKdigits(self, num: str, k: int) -> str:
#         if len(num) == k:
#             return '0'
#         self.min = float('inf')
#         self.check = [False] * len(num)
#         lst = list(num)
#         self.helper(lst, k, [], 0)
#         return str(self.min)