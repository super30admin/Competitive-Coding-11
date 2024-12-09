# Problem 1: Evaluate Reverse Polish Notation
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        st = []
        i = 0
        n = len(tokens)
        op = ["+","-","*","/"]
        while i <= n-1:
            c = tokens[i]
            if c not in op :
                st.append(c)
            elif c == "+":
                num1 = st.pop()
                num2 = st.pop()
                Sum = int(num1)+int(num2)
                st.append(str(Sum))
            elif c == "-":
                num1 = st.pop()
                num2 = st.pop()
                Diff = int(num2)-int(num1)
                st.append(str(Diff))
            elif c == "*":
                num1 = st.pop()
                num2 = st.pop()
                Prod = int(num1)*int(num2)
                st.append(str(Prod))
            elif c == "/":
                num1 = st.pop()
                num2 = st.pop()
                Div = int(int(num2) / int(num1))
                st.append(str(Div))

            i += 1

        return int(st[0])
            

            


        