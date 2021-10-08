#time- O(n)
#space-O(size of list s)-->O(n)
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        oper='*+/-'
        s=[]
        for i in tokens:
            if  i.lstrip('-+').isdigit():
                s.append(int(i))
            else:
                if len(s)>=2:
                    if i=='*':
                        ans=s[-2]*s[-1]
                    elif i=='/' :
                        ans=int(s[-2]/s[-1])
                    elif i=='+' :
                        ans=s[-2]+s[-1]
                    elif i=='-':
                        ans=s[-2]-s[-1]
                    s.pop()
                    s.pop()
                    s.append(ans)
            #print(s)
        return s[-1]
                
                
                
        
