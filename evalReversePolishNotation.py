class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        """Time complexity-O(n)
        Space complexity-O(n)"""
        arr=[]
        hashset=set()
        hashset.add("+")
        hashset.add("-")
        hashset.add("/")
        hashset.add("*")
        for i in range(len(tokens)):
            if tokens[i] in hashset:
                temp1=arr.pop()
                temp2=arr.pop()
                if tokens[i]=="*":
                    arr.append(temp1 * temp2)
                elif tokens[i]=="+":
                    arr.append(temp1 + temp2)
                elif tokens[i]=="-":
                    arr.append(temp2 - temp1)
                elif tokens[i]=="/":
                    arr.append(int(temp2 / temp1))
            else:
                ch=int(tokens[i])
                arr.append(ch)
        return arr[-1]
                
        