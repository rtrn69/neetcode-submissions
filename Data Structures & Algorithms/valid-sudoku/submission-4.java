class Solution {
    public boolean isValidSudoku(char[][] board) {
        // use hashset so that only distinct elements can be added to the set 
        // hashset does not allow duplicate elements 
        HashSet<String> map = new HashSet<>();

        // iterate through each elem in 2d arr
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char num = board[i][j];

                // check each elem if there's a duplicate 
                // works cuz 
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


