"""
Leetcode: https://leetcode.com/problems/remove-k-digits/

Approach: Greedy with Stack

Time complexity : O(N). Although there are nested loops, the inner loop is bounded to be run at most k times
 globally. Together with the outer loop, we have the exact (N+k) number of operations.
 Since 0<k≤N, the time complexity of the main loop is bounded within 2N.
 For the logic outside the main loop, it is clear to see that their time complexity is O(N).
 As a result, the overall time complexity of the algorithm is O(N).

Space complexity : O(N). We have a stack which would hold all the input digits in the worst case.
"""


class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        numStack = []

        # Construct a monotone increasing sequence of digits
        for digit in num:
            while k and numStack and numStack[-1] > digit:
                numStack.pop()
                k -= 1

            numStack.append(digit)

        # - Trunk the remaining K digits at the end
        # - in the case k==0: return the entire list
        finalStack = numStack[:-k] if k else numStack

        # trip the leading zeros
        return "".join(finalStack).lstrip('0') or "0"