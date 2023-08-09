#TIme complexity is O(n)
#Space complexity is O(n)
#No issues faced while coding
#Code ran successfully on leetcode
class Solution(object):
    def evalRPN(self, tokens):
        """
        :type tokens: List[str]
        :rtype: int
        """
        #Initializing an empty stack
        stack=[]
        #Creating a hashset and inserting operators into that
        _set=set()
        _set.add("+")
        _set.add("-")
        _set.add("*")
        _set.add("/")
        #We will go through each value in the token
        for s in tokens:
            #If s is a tocken, we will pop top two values from stack
            if(s in _set):
                first=stack.pop()
                second=stack.pop()
                #Based on the operatorm we will claculate the value
                if(s=="+"):
                    stack.append(first+second)
                elif(s=="-"):
                    stack.append(second-first)
                elif(s=="*"):
                    stack.append(second*first)
                else:
                    #Handling division for negative cases
                    flag=0
                    if(second<0):
                        second*=-1
                        flag+=1
                    if(first<0):
                        first*=-1
                        flag+=1
                    if(flag==1):
                        stack.append(-1*int(second/first))
                    else:
                        stack.append(int(second/first))
            #If the value is not i set, we will append that into the stack
            else:
                stack.append(int(s))
        #Finally we are popping the result value from the stack
        return stack.pop()

        