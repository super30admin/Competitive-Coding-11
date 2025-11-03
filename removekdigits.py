# Time Complexity : O(N) as the we are iterating through the number string once
# Space Complexity : O(N) as we are using extra space to store the stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes

# Your code here along with comments explaining your approach:
# I am using a stack to keep track of the digits in the number.
# I will iterate through each digit in the number string.
# For each digit, I will compare it with the top of the stack.
# If the current digit is smaller than the top of the stack and we still have k digits to remove, I will pop the top of the stack.
# I will continue this until either the stack is empty, k is 0, or the current digit is not smaller than the top of the stack.
# After processing all digits, if there are still k digits to remove, I will pop the remaining digits from the end of the stack.
# Finally, I will construct the resulting number from the stack, removing any leading zeros, and return it.

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        n = len(num)
        if n == k:
            return "0"
        stack = []
        i = 0
        while i < n:
            while stack and k != 0 and stack[-1] > num[i]:
                stack.pop()
                k -= 1
            stack.append(num[i])
            i += 1
        while k > 0:
            print(k)
            stack.pop()
            k -= 1
        ans = ''.join(stack).lstrip("0") 
        return ans if ans != "" else "0" # just to handle one case "10" then would become ""
        