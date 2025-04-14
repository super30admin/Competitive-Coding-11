//The idea here is to use BFS to traverse through the matrix to find the minimum number of steps to reach the destination.
//To also keep track of the k that are used and explored and to not visit them again, we take a visited 3d matrix where we mark the visited index with the given row, column and k
//Time Complexity: O(m*n*k) where m and n are lengths of rows and columns of the matrix
//Space Complexity: O(m*n*k)
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int[][] dirs = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
        int level = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][][] visited = new int[m][n][k+1];
        q.add(new int[]{0,0,k});
        visited[0][0][k] = -1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                int[] curr = q.poll();
                if(curr[0] == m-1 && curr[1] ==  n-1) return level;
                for(int[] dir: dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    int kVal = curr[2];
                    if(nr >=0 && nr < m && nc >=0 && nc < n){
                        if(grid[nr][nc] == 1 && kVal > 0 && visited[nr][nc][kVal - 1] != -1){
                            q.add(new int[]{nr, nc, kVal-1});
                            visited[nr][nc][kVal - 1] = -1;
                        }
                        if(grid[nr][nc] == 0 && visited[nr][nc][kVal] != -1){
                            q.add(new int[]{nr, nc, kVal});
                            visited[nr][nc][kVal] = -1;
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}