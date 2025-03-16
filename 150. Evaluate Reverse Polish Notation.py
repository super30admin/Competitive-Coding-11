#time:O(n)
#space: O(n)
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:

        if len(tokens)== 0:
            return

        n= len(tokens)
        s=[]
        # operators= '+-/*'
        # # print('len of s', len)
        for i in range(n):
            
            if tokens[i].isdigit() or (tokens[i].startswith('-') and tokens[i][1:].isdigit()):
                s.append(int(tokens[i]))
                # print('current stack is',s)
            elif len(s) >1:
                op2=s.pop()
                op1=s.pop()
                res=int()
                if tokens[i]=='+':
                    res= op1 + op2
                elif tokens[i]=='-':
                    res= op1 - op2
                elif tokens[i]=='*':
                    res= op1 * op2
                if tokens[i]=='/':
                    res= op1 / op2
                s.append(int(res))
        return s.pop()

    #     def is_number(self, s):
    # return s.isdigit() or (s.startswith('-') and s[1:].isdigit())



        
