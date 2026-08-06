class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int cols = matrix[0].length;
        int low = 0, high = matrix.length * cols - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midRow = mid / cols;
            int midCol = mid % cols;

            if (matrix[midRow][midCol] == target) {
                return true;
            } else if (matrix[midRow][midCol] < target) {
                low = (midRow * matrix[0].length) + midCol + 1;
            } else {
                high = (midRow * matrix[0].length) + midCol - 1;
            }
        }
        
        return false;
    }
}
