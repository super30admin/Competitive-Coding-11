# time complexity is o(n), where n is the size of the input
# space complexity is o(n), where n is the size of the input
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        
        n = len(num)
        curr  = 0
        stack = []
        res = ''
        
        for i in num:
            while(k > 0 and len(stack) > 0 and stack[-1] > int(i)):
                stack.pop()
                k -= 1
            stack.append(int(i))
            
#        while(curr < n):
#             stack.append(int(num[curr]))
#             # print(stack)
#             curr += 1
            
#         print(stack, k) 
        
#         zerolist = []

        while(k > 0):
            stack.pop() 
            k -= 1
            
        if(len(stack) == 0):
            return "0"
        
        while(len(stack) > 0):
            m = stack.pop()
            res = str(m) + res
        return str(int(res))
    
            
                
            
            
            
# #         l = len(num) - 1
# #         from heapq import heappush
# #         from heapq import heappop
# #         heap = []
# #         n = int(num)
# #         class Node:
# #             def __init__(self, ind, val):
# #                 self.ind = ind
# #                 self.val = val
                
# #             def __lt__(self, other):
# #                 return self.val < other.val
# #         ind = 0
# #         while(n > 0):
# #             divisor = 10**(ind + 1)
# #             r = n % divisor
# #             tempNode = Node(l - ind, r)
# #             heappush(heap, tempNode)
# #             while(len(heap) > k):
# #                 heappop(heap)
# #             n = n - r
# #             # print(n, r, l - ind)
# #             ind += 1
            
# #         nodeList = []
# #         while(len(heap) > 0):
# #             temp = heappop(heap)
# #             nodeList.append(temp.ind)
# #         nodeList.sort()
# #         prev = 0
# #         res = ''
# #         # print(nodeList)
# #         for i in nodeList:
# #             res += num[prev : i]
# #             prev = i+1
# #         res += num[prev : ]
# #         return res
            
            
#     # 13597
#     # 16489
            
        
        