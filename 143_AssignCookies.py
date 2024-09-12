'''
Accepted on leetcode(455)
time - O(NlogN+MlogM)
space - O(1)
'''


class Solution:
    def findContentChildren(self, g, s) -> int:
        # edge case
        if len(g) == 0 or len(s) == 0:
            return 0

        # sort both greed and cookies array
        g.sort()
        s.sort()

        count = 0  # also used as indx for greed array.

        for c in s:
            if count >= len(g):
                break
            if c >= g[count]:
                count += 1

        return count