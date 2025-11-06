# Space Complexity: O(N)
# Time Complexity: O(N)
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        st = collections.deque()

        for tk in tokens: 
            if tk == '/': 
                second_element = st.pop()
                first_element = st.pop()
                st.append(int(first_element / second_element))

            elif tk == '*': 
                second_element = st.pop()
                first_element = st.pop()

                st.append(first_element * second_element)

            elif tk == '-': 
                second_element = st.pop()
                first_element = st.pop()

                st.append(first_element - second_element)

            elif tk == '+':
                second_element = st.pop()
                first_element = st.pop()

                st.append(first_element + second_element)
            else: 
                num = int(tk)
                st.append(num)
        
        return st[-1]
