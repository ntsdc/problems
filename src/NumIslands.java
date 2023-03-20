public class NumIslands {
}

class Solution200 {

    boolean[][] visited;
    int res = 0;

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j);
                    visited[i][j] = true;
                    res++;
                }
            }
        }
        return res;

    }

    public void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i + 1 < m && grid[i + 1][j] == '1' && !visited[i + 1][j]) {
            visited[i + 1][j] = true;
            dfs(grid, i + 1, j);
        }
        if (i - 1 >= 0 && grid[i - 1][j] == '1' && !visited[i - 1][j]) {
            visited[i - 1][j] = true;
            dfs(grid, i - 1, j);
        }
        if (j + 1 < n && grid[i][j + 1] == '1' && !visited[i][j + 1]) {
            visited[i][j + 1] = true;
            dfs(grid, i, j + 1);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1' && !visited[i][j - 1]) {
            visited[i][j - 1] = true;
            dfs(grid, i, j - 1);
        }
    }
}

class Solution200_new { //效率优化版
    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }
}
