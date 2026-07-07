class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int[] soln = new int[2];

        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right -= 1;
            } else if (numbers[left] + numbers[right] < target) {
                left += 1;
            } else {
                soln[0] = left + 1;
                soln[1] = right + 1;

                return soln;
            }
        }

        return soln; 
    }
}
