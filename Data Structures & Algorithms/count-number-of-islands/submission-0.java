class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islands = 0;
        for (int r=0; r<grid.length; r++) {
            for(int c=0; c<grid[0].length; c++) {
                if (!visited[r][c] && grid[r][c]=='1') {
                    islands++;
                    dfs(grid, r, c, visited);
                }
            }
        }
        return islands;
        
    }
    
    void dfs(char[][] grid, int row, int col, boolean[][] visited) {
        if (row >= grid.length || row <0) {
            return;
        } else if (col >= grid[0].length || col<0) {
            return;
        }
        if (visited[row][col]) {
            return;
        }
        if (grid[row][col] =='0') {
            return;
        }

        visited[row][col] = true;

        // valid cell not visited
        if (grid[row][col] == '1') {
            // left
            dfs(grid, row, col-1, visited);
            //right
            dfs(grid, row, col+1, visited);
            //up
            dfs(grid, row-1, col, visited);
            //down
            dfs(grid,row+1, col, visited);
        }
    }
}
