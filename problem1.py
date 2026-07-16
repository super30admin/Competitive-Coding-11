"""
1. At any point of time, we compare only 2 elements, say 1st and 2nd.
2. If the first element is the winner, then we increment winning ct and move ahead
3. Else we reset the winning streak, once k consecutive wins are seen, we can return that element.

TC: O(n)
SC: O(1)
"""


class Solution:
    def getWinner(self, arr: List[int], k: int) -> int:

        if not arr or len(arr) == 0 :
            return -1
        
        i = 0
        j = 1

        l = len(arr)
        ct = 0
        while j<l:
            # Check if winner is 2nd element
            if arr[j] > arr[i]:
                i = j
                j+=1
                ct = 1
            # winner is 1st element, keep increasing ct and move ahead with next element to compare
            else:
                j+=1
                ct += 1
            # Break if k consecutive rounds are won
            if ct == k:
                return arr[i]

        return arr[i]

        