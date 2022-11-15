class Solution:
    def evalRPN(self, tokens):
        st = list()
        hashSet = set()

        hashSet.add("+")
        hashSet.add("-")
        hashSet.add("*")
        hashSet.add("/")

        for s in tokens:
            if s in hashSet:
                first = st.pop()
                second = st.pop()
                if s == "+":
                    st.append(int(second + first))
                elif s == "-":
                    st.append(int(second - first))
                elif s == "*":
                    st.append(int(second * first))
                elif s == "/":
                    st.append(int(second / first))
            else:
                st.append(int(s))
        print(st.pop())
        return st.pop()


tokens = ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
obj = Solution()
obj.evalRPN(tokens)

# Stack
# Time Complexity : O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
