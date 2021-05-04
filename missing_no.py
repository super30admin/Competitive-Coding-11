""" Time Complexity : O(logn)
 Space Complexity : O(1)
 Did this code successfully run on Leetcode :Yes
 Any problem you faced while coding this : No 
"""

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        
        low,high = 0, len(nums) - 1
	
        while(low <= high):
            mid = int(low + (high-low)/2 )


            if mid != 0 and nums[mid] - nums[mid-1] == 2:
                return nums[mid] - 1

            elif mid == len(nums) - 1 and nums[mid+1] - nums[mid] == 2:
                return nums[mid+1] - 1

            elif mid == 0 and nums[0] != 1:
                return nums[mid] - 1

            elif mid == len(nums) - 1 and nums[mid] != len(nums):
                return nums[mid] - 1			

            elif len(nums[0:mid]) != nums[mid] - nums[0] :
                high = mid -1
            else:
                low = mid + 1

        return -1