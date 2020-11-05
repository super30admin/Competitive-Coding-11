# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach:
# Brute Force: Backtracking gives you all possible combinations and then we can choose the number thats smallest with exponential time complexity
# Optimal intuition: if n[i]>n[i+1] then skip that number! Now, again start from beginning and check the same condition and repeat this for k times, resulting in O(kn). 
#Using stacks: Push digits in the stack, pop it out if top of stack is greater than n[i].
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        
        stack = []
        
        for n in num:
            while stack and k>0 and stack[-1]>n:
                k -= 1
                stack.pop()
            stack.append(n)
        
        if k > 0:
            stack = stack[:-k]

        return ''.join(stack).lstrip('0') or '0'
            
            