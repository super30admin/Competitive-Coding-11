from collections import deque
class Solution:
    def shortestPath(self, grid, k):
        if grid is None:
            return 0

        m = len(grid)
        n = len(grid[0])
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        visited = [[[False] * n for i in range(m)] for j in range(k + 1)]
        visited[k][0][0] = True
        q = deque()
        # i  j  k
        q.append([0, 0, k])
        result = 0

        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if curr[0] == m - 1 and curr[1] == n - 1:
                    print(result)
                    return result
                for d in dirs:
                    nr = d[0] + curr[0]
                    nc = d[1] + curr[1]
                    if nr >= 0 and nc >= 0 and nr < m and nc < n:
                        # if there is an obstacle in the neighbor row index, if yes then obstacle is reduced by 1
                        K = curr[2] - grid[nr][nc]
                        if K >= 0 and not visited[K][nr][nc]:
                            q.append([nr, nc, K])
                            visited[K][nr][nc] = True
            result += 1

        return -1

grid = [[0,1,0,1],[0,1,0,0],[0,0,1,0],[1,0,0,1],[0,1,0,0]]
k = 18

if __name__ == "__main__":
    obj = Solution()
    obj.shortestPath(grid, k)

#BFS
#Time Complexity: O(m * n * k)
#Space Complexity: O(m * n * k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No