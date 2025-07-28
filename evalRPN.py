# TimeComplexity:O(n)
# SpaceComplexity:O(n)
# Approach This is classic stack problem Process things that came last first LIFO . Insert in stack if its number .
# if its symbol pop last two number and process things and then insert in stack





class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        st=[]
        for token in tokens:
            if token not in "+-*/":
                st.append(int(token))
            else:
                a=st.pop()
                b=st.pop()
                if token=='+':
                    st.append(b+a) 
                elif token=='-':
                    st.append(b-a)
                elif token=='*':
                    st.append(b*a)
                elif token=='/':
                    st.append(int(b/a))    
        return (st[0])
