"""
Time Complexity : O(n+k)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : no

The bruteforce would be to choose a number to be removed or not at every point until we get k=0. Do this recursively 
with backtracking. Whenever k=0, store the result and compare everytime we get a result and give out the minimum at end.
This would be exponential. To optimise this, we can keep a stack and start iterating the number. Whenevr we find a number which 
is smaller than number on top of stack, we start popping out and decrementing k unless we find a lesse value or stack empties
or k becomes 0. After we are done iterating, still value of k might not become 0, like in example of 15234 and k=2. So,
we need to pop out of stack(as top of stack would have greater value) until k becomes 0. Now, the value inside stack is the
least possible, so we make a string out of it and remove any leading 0s. In case, the stack is already empty, no number is 
possible and we return 0, or return the string otherwise.
"""


class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        for n in num:
            while stack and k > 0 and stack[-1] > n:
                k -= 1
                stack.pop()
            stack.append(n)
        while k > 0:
            stack.pop()
            k -= 1
        result = ''.join(stack).lstrip('0')
        return result or '0'
