import java.util.LinkedList;
import java.util.Queue;

class ShortestPathGridElimination {
    public int shortestPath(int[][] grid, int k) {

        int m = grid.length, n = grid[0].length;
        boolean[][][] visited = new boolean[m][n][k + 1];

        Queue<int[]> Q = new LinkedList();
        Q.add(new int[]{0, 0, k});
        //0 index -> x coordinate
        //1 index -> y coordinate
        //2 index -> obstacle count

        int res = 0;

        while(Q.size() > 0){
            int size = Q.size();

            while(size-- > 0){

                int[] rem = Q.remove();
                int x = rem[0];
                int y = rem[1];
                int obs = rem[2];

                if(x == m - 1 && y == n - 1 && obs >= 0)   return res;     // reached end

                if(obs < 0 || visited[x][y][obs] == true)  continue;
                visited[x][y][obs] = true;

                // up
                if(x - 1 >= 0){
                    Q.add(new int[]{x - 1, y, obs - grid[x - 1][y]});
                }

                // down
                if(x + 1 < m){
                    Q.add(new int[]{x + 1, y, obs - grid[x + 1][y]});
                }

                // left
                if(y - 1 >= 0){
                    Q.add(new int[]{x , y - 1, obs - grid[x][y - 1]});
                }

                // right
                if(y + 1 < n){
                    Q.add(new int[]{x , y + 1, obs - grid[x][y + 1]});
                }
            }
            ++res;
        }
        return -1;
    }

    public static void main(String[] args){
        ShortestPathGridElimination obj = new ShortestPathGridElimination();
        int[][] grid = {{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
        int k = 1;
        System.out.println(obj.shortestPath(grid,k));
    }
}