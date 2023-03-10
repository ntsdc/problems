public class WordExist {
    public static void main(String[] args) {
        System.out.println(new Solution79().exist(new char[][]
                        {
                                {'A', 'B', 'C', 'E'},
                                {'S', 'F', 'E', 'S'},
                                {'A', 'D', 'E', 'E'},
//                                {'C','A','A'},
//                                {'A','A','A'},
//                                {'B','C','D'},


                        }

                , "ABCESEEEFS"));


    }
}

class Solution79 {
    private boolean res = false;

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    backtrack(board, word, 1, i, j, visited);
                }
            }
        }
        return res;
    }

    public void backtrack(char[][] board, String word, int index, int x, int y, boolean[][] visited) {
        if (index == word.length()) {
            res = true;
            return;
        }
        visited[x][y] = true;
        int m = board.length, n = board[0].length;
        char[] chars = word.toCharArray();
        if (x + 1 < m && board[x + 1][y] == chars[index] && !visited[x + 1][y]) {
            backtrack(board, word, index + 1, x + 1, y, visited);
            visited[x + 1][y] = false;
        }
        if (x - 1 >= 0 && board[x - 1][y] == chars[index] && !visited[x - 1][y]) {
            backtrack(board, word, index + 1, x - 1, y, visited);
            visited[x - 1][y] = false;
        }
        if (y + 1 < n && board[x][y + 1] == chars[index] && !visited[x][y + 1]) {
            backtrack(board, word, index + 1, x, y + 1, visited);
            visited[x][y + 1] = false;
        }
        if (y - 1 >= 0 && board[x][y - 1] == chars[index] && !visited[x][y - 1]) {
            backtrack(board, word, index + 1, x, y - 1, visited);
            visited[x][y - 1] = false;
        }
        visited[x][y] = false;
    }
}