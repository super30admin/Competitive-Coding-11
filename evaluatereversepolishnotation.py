#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        st = []
        n = len(tokens)
        operands = ('+', '-', '*', '/')
        res = float("-inf")

        if n == 1:
            return int(tokens[0])

        for i in range(n):
            if tokens[i] in operands:
                val1 = st.pop()
                val2 = st.pop()

                if tokens[i] == '+':
                    res = val2 + val1


                elif tokens[i] == '-':
                    res = val2 - val1

                elif tokens[i] == '*':
                    res = val2 * val1

                else:
                    res = int(val2 / val1)

                st.append(res)

            else:
                st.append(int(tokens[i]))

        return res
