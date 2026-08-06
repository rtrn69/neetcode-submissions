class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0, high = matrix.length * matrix[0].length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midRow = mid / matrix[0].length;
            int midCol = mid % matrix[0].length;

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
