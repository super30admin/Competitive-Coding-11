#Leetcode : Pass
#TC - O(nlogn), SC-O(1)
#1) sort the arrays
#2) compare the elements in both array if cookie_size>= greed is satisfied then assign the child with the cookie and increase both pointers
#3) else just inscrease the ptr of cookie_size array
class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        #1
        g.sort()
        s.sort()
        greed=cookie=0
        while greed < len(g) and cookie < len(s):
            #2
            if s[cookie] >= g[greed]:
                greed +=1
            #3
            cookie +=1
        return greed
