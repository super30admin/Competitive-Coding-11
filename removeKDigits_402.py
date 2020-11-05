# Time Complexity : 
# Space Complexity :
# Did this code successfully run on Leetcode : 
# Any problem you faced while coding this : 

# Approach:
# Brute Force: Backtracking gives you all possible combinations and then we can choose the number thats smallest with exponential time complexity
# Optimal intuition: if n[i]>n[i+1] then skip that number! Now, again start from beginning and check the same condition and repeat this for k times, resulting in O(kn) 
