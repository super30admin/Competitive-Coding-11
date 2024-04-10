'''
TC: O(logn) - using binary search to implement
SC: O(1) - few pointers to store
'''
from typing import List

class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        l,r = 0,len(nums)-1
        while l<r:
            mid = (l+r)//2
            if (mid)%2!=0:
                mid = mid-1
            if nums[mid] == nums[mid+1]:
                l = mid+2
            else:
                r = mid
        return nums[l]
s = Solution()
print(s.singleNonDuplicate([1,1,2,3,3,4,4,8,8]))
print(s.singleNonDuplicate([3,3,7,7,10,11,11]))