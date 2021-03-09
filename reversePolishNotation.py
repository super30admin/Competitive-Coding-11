# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

#array of strings
def getVal(arr):
    if not arr:
        return 0
    
    stack = []
    
    #assume array is always valid
    for i in range(len(arr)):
        #if it's an operator ( + - * /) we just do operations on the last two numbers from the stack
        if arr[i] == '+':
            val1 = stack.pop()
            val2 = stack.pop()
            stack.append(val1+val2)
        elif arr[i] == '-':
            val1 = stack.pop()
            val2 = stack.pop()
            stack.append(val2-val1)
        elif arr[i] == '*':
            val1 = stack.pop()
            val2 = stack.pop()
            stack.append(val1*val2)
        elif arr[i] == '/':
            val1 = stack.pop()
            val2 = stack.pop()
            stack.append(val2//val1)
        #append number to stack
        else:
            stack.append(int(arr[i]))
            
    return stack.pop()

arr = ["2", "1", "+", "3", "*"]
print(getVal(arr))

arr = ["4", "13", "5", "/", "+"]
print(getVal(arr))
     






