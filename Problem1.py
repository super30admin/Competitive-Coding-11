class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        # Time Complexity : O(n) we are iterating through each and every element of the list
        # Space Complexity : O(n) we are storing each and every value of the tokens list to the stack
        # Got accepted on Leetcode
        st = []
        actions = {"+": (lambda x,y: x+y), "-": (lambda x,y: x-y), "*": (lambda x,y: x*y), "/": (lambda x,y: int(x/y))}
        for i in tokens:
            if i in actions:
                num2 = st.pop()
                num1 = st.pop()
                res = actions[i] (num1, num2)
                st.append(res)
            else:
                st.append(int(i))
        return st.pop()