# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        st = []  
        
        for token in tokens:
            if token not in '+-/*':
                st.append(int(token))
                continue
            
            num_2 = st.pop()
            num_1 = st.pop()
            result = 0
            if token == '+':
                result = num_1 + num_2
            elif token == '-':
                result = num_1 - num_2
            elif token == '/':
                result = int(num_1/num_2)
            else:
                result = num_1 * num_2
            st.append(result)
                
        return st[-1]