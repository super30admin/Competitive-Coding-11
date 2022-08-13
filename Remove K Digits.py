""""// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""


class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        if len(num) <= k:
            return '0'
        st = []
        for i in num:
            while k > 0 and st and int(st[-1]) > int(i):
                st.pop()
                k -= 1
            st.append(i)
        while k > 0:
            st.pop()
            k -= 1

        return str(int("".join(st)))

