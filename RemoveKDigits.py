# // Time Complexity :o(n)
# // Space Complexity :o(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no


# // Your code here along with comments explaining your approach
# We use a stack to store digits and keep removing the top if the current digit is smaller and we still have k left.
# We remove remaining digits from the end if k is still not zero after the loop.
# We build the result by skipping leading zeros and return "0" if everything got removed.

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        st = []
        res = []
        for i in range(len(num)):
            c = num[i]
            while st and k>0 and st[-1] > c:
                # pop from stack
                st.pop()
                k-=1
            # append to the stack if increasing
            st.append(c)
        # if the k was never filled
        while k>0:
            k-=1
            st.pop()
        # remove preceding 0's
        i = 0 
        while st and i < len(st) and st[i] == "0":
            i+=1
        res = st[i:]
        return "".join(res) if res else "0"

        