# Created by Aashish Adhikari at 9:53 PM 3/22/2021

'''
Time Complexity:
O(n)

Space Complexity:
O(1)
'''

class Solution(object):
    def maxChunksToSorted(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """

        max_in_current_partition = 0
        total_partitions = 0

        for idx in range(0, len(arr)):

            if arr[idx] == idx and max_in_current_partition == idx: # max_in_current_partition == idx required to handle cases like [0,4,2,3,1] where 2 and 3 are in correct positions but the partition end hasnt arrived.
                total_partitions += 1
                max_in_current_partition = idx
            else:
                max_in_current_partition = max(max_in_current_partition, arr[idx])

                if max_in_current_partition == idx:
                    total_partitions += 1
                    max_in_current_partition = idx
        return total_partitions




