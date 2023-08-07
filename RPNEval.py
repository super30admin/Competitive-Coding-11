# Time complexity - O(n)
#  Space complexity - O(n)
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        expression=["+","-","/","*"]
        st=[]
        cal=0
        if(len(tokens)==1):
            return int(tokens[0])
        for i in tokens:
            if i not in expression:
                st.append(int(i))
                
            else:
                c1,c2=0,0
                c2=st.pop()
                c1=st.pop()
                if i == "+":
                    cal=c1+c2
                elif i == "-":
                    cal=c1-c2
                elif i == "/":
                    cal=int(c1/c2)
                else:
                    cal=c1*c2
                st.append(cal)
        return cal
                