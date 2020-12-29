# Time:- O(n)
# Space:- O(n)
# Approach: Append to a stack on encountering an operator pop the last 2 numbers from the stack perform 
# the operation on them and store the result back into the stack. In division we have to truncate towards 
# zero so if the number is greater than 0 we take math.floor and if less than 0 we take ceil.
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        token_stack=[]
        for i in tokens:
            if i=="+" or i=="-" or i=="*" or i=="/":
                second_value=token_stack.pop()
                first_value=token_stack.pop()
                if i=="+":
                    token_stack.append(first_value+second_value)
                if i=="-":
                    token_stack.append(first_value-second_value)
                if i=="*":
                    token_stack.append(first_value*second_value)
                if i=="/":
                    val=first_value/second_value
                    if val<0:
                        token_stack.append(math.ceil(val))
                    else:
                        token_stack.append(math.floor(val))
                        
            else:
                token_stack.append(int(i))
        return token_stack.pop()