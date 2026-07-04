class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> map = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char num = board[i][j];

                if (num != '.') {
                    if (!map.add(num + "at row" + i) || 
                        !map.add(num + "at col" + j) ||
                        !map.add(num + "at box" + i/3 + "-" + j/3)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}


