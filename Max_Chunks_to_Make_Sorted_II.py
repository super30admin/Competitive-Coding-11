# Created by Aashish Adhikari at 9:54 PM 3/22/2021

'''
Time Complexity:
O(nlogn)

Space Complexity:
O(n)
'''

class Solution(object):


    def maxChunksToSorted(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """

        '''
        If the array is sorted, the sum from the 0th element to ith element in the sorted array should equal the sum from the 0th element to ith element in the unsorted array.
        '''


        unsort = copy.deepcopy(arr) # O(n) time and space

        arr.sort()

        total, unsorted_sum_upto_idx, sorted_sum_upto_idx = 0, 0, 0

        for idx in range(0,len(arr)): # O(n)

            unsorted_sum_upto_idx += unsort[idx]
            sorted_sum_upto_idx += arr[idx]

            if unsorted_sum_upto_idx == sorted_sum_upto_idx:
                total += 1

        return total
        