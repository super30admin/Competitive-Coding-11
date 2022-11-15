class Solution:
    def removeKdigits(self, nums: str, k: int) -> str:
        st = []  # creating an empty stack

        # 1.append the elements in the stack
        # 2. check the top element in the stack whether it is greater than the
        # current in the loop if greater pop the top element and reduce k by 1
        # 3. append the current element in the stack
        for num in nums:
            while k > 0 and st and st[-1] > num:
                st.pop()
                k -= 1
            st.append(num)
        # we pop k number of elements from stack if k > 0
        for i in range(k):
            st.pop()

        # convert the remianing elements in the stack to string
        # also remove leading zeros
        # "10200", k = 1 for this case the answer will return
        # 0200 but o/p shoul be 200

        string = "".join(st).lstrip("0")

        if not string:
            return "0"

        return string

# Stack
# Time Complexity: O(2n + k)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
